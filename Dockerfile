FROM adoptopenjdk/openjdk8:ubi
ENV HOME=/app
WORKDIR $HOME
COPY build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]