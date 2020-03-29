FROM openjdk:8-jre

ADD ./target/msa3-svc-member.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa3-svc-member.jar"]

EXPOSE 9091