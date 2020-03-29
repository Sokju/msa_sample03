package com.msa_sample03.svc.member.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa_sample03.svc.member.domain.Member;
import com.msa_sample03.svc.member.service.MemberService;

@RestController
public class MemberRestController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberService	memberService;
	
	@RequestMapping(value = "/member/{memberName}", method = RequestMethod.GET)
	public Member getMemberByName(@PathVariable("memberName") String memberName) {
		
		log.debug("############ getMemberByName : " + memberName);
		
		return memberService.findByName(memberName);
	}
	
	public Member fallbackMemberByName(@PathVariable("memberName") String memberName) {
		
		log.debug("############ fallbackMemberByName : " + memberName);
		
		Member member = new Member();
		member.setName(memberName);
		member.setComment("fallbackMemberByName");
		return member;
	}


	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public void createMember(@Valid @RequestBody Member member) {
		
		log.debug("############ createMember : " + member.getName());
		
		memberService.createMember(member);
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.PUT)
	public void updateMember(@Valid @RequestBody Member member) {
		
		log.debug("############ updateMember : " + member.getName());
		
		memberService.updateMember(member);
	}
	
	@RequestMapping(value = "/member/{memberName}", method = RequestMethod.DELETE)
	public void deleteMemberByName(@PathVariable("memberName") String memberName) {
		
		log.debug("############ updateMember : " + memberName);
		
		memberService.deleteMember(memberName);
	}
	
	@RequestMapping(value = "/member/fallbackTest", method = RequestMethod.GET)
	public String fallbackTest() throws Throwable{
		throw new Throwable("fallbackTest");
	}
	public String fallbackFunction(){
		return "fallbackFunction()";
	}
	
}
