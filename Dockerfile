FROM maven:3.8.2-openjdk-17
WORKDIR /CDQTask
COPY . .
RUN mvn clean install -DskipTests=true
CMD mvn spring-boot:run
