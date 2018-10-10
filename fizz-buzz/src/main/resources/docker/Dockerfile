FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD fizz-buzz-0.0.1-SNAPSHOT.jar fizz-buzz.jar
RUN sh -c 'touch /fizz-buzz.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /fizz-buzz.jar" ]  
