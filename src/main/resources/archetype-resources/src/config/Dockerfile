# ------------------------------------------------------------------------
#
# Directorio de ubicacion de todos los microservicio /opt/<NOMBRE>
#
# docker build -f Dockerfile -t ${artifactId} .
# 
# ------------------------------------------------------------------------

FROM openjdk:8-jdk-alpine
MAINTAINER coearquitectura@telefonica.com

VOLUME /tmp
ADD ${artifactId}.jar /opt/microservice/
EXPOSE 8080
WORKDIR /opt/microservice/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "${artifactId}.jar"]
#ENTRYPOINT [ "sh", "-c", "java -jar $JAVA_OPTS /opt/mobile-app-ws/${artifactId}.jar" ]