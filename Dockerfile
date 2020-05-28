FROM openjdk:11-jre
CMD ./gradlew build && java -jar build/libs/anagram-application.jar
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]