# To define base image for the image
FROM java:8-jdk-alpine

# To display authors of the project
MAINTAINER saikalyan2703@gmail.com

# To copy executable from host to container
COPY ./target/demo-0.0.1-SNAPSHOT.jar /usr/app

# Change working directory inside container
WORKDIR /use/app

RUN sh -c 'touch demo-0.0.1-SNAPSHOT.jar'

# To show what ports to open in container
EXPOSE 8091

CMD ["/usr/bin/java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]