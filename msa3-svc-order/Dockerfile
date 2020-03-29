FROM openjdk:8-jre

ADD ./target/msa3-svc-order.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa3-svc-order.jar"]

EXPOSE 9092