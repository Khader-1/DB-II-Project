FROM maven:3.8.2-jdk-8

WORKDIR /server
COPY . .
RUN mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dmaven.source.skip=true 
CMD mvn spring-boot:run
