FROM thingsboard/openjdk11:latest
ARG JAR_FILE=build/libs/joylog-blog-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} joylog.jar
#CMD java -jar joylog.jar -Dspring.properties=prod

EXPOSE 80 80

# root 대신 nobody 권한으로 실행
#USER nobody
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "-Dspring.profiles.active=dev", \
    "/joylog.jar"              \
]
