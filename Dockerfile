FROM openjdk:8-jdk-alpine
COPY /target/dndbattleappbe-0.0.1-SNAPSHOT.war dndbattleappbe-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/dndbattleappbe-0.0.1-SNAPSHOT.war"]