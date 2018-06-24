From centos

Run yum install -y java

VOLUME /tmp
ADD /target/vestibular-backend-1.0.0.jar vestibular-backend.jar
RUN sh -c 'touch /vestibular-backend.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/;/urandom","-jar","/vestibular-backend.jar"]

