FROM gradle:7.4-jdk11-alpine
WORKDIR /app
COPY ./ ./
RUN gradle clean build
#CMD java -jar build/libs/*.jar -Dspring.properties=prod

EXPOSE 80 80

# root 대신 nobody 권한으로 실행
#USER nobody
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "-Dspring.profiles=dev", \
    "build/libs/joylog-blog-0.0.1-SNAPSHOT.jar"              \
]