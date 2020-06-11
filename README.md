
MSA 샘플 유형 3(Istio)
======================

# 1. msa3-svc-member
* 임의의 마이크로서비스 샘플 1
* ConfigMap 연동하여  설정 (configmap.yml 참조)
* Port : 9091
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 배포 테스트
* RabbitMQ를 통해  msa-svc-order 호출 예제 테스트

# 2. msa3-svc-order
* 임의의 마이크로서비스 샘플 2
* Spring Cloud Config 서버 연동
* Port : 9092
* Dockerfile 로 빌드 후 
* Kubernetes 에 yml 로 pod 배포 테스트
* RabbitMQ Subscribe 테스

# 3. msa3-svc-product
* 임의의 마이크로서비스 샘플 3
* Spring Cloud Config 서버 연동
* Port : 9094
* Dockerfile 로 빌드 후 
* Kubernetes 에 yml 로 pod 배포 테스트

# 4. msa3-svc-ui
* Frontend UI 용 마이크로서비스  예제(미완성)
* 원래 Spring Security 연동 로그인 처리, 임의의 서비스 2개 호출 예제로 정리
* Port : 9093

# 5. Istio 관련 설정
* KB 테스트 내용을 반영 못했음
* platform_config 폴더내, Gateway, VirtualService, DestinationRule 등의 설정을 포함시키고자 함





