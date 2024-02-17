# Docker Setup:
### Start your Docker Engine using below commands
> sudo systemctl start docker
### To check the Docker Engine Status
> sudo systemctl status docker

### If you are using Linux Machine first install maven using:
> sudo apt install maven

> sudo mvn spring-boot:build-image "-Dspring-boot.build-image.imageName=<imageName>"

### Login using below command
> sudo docker login (For Linux)
> docker login (For Windows)

### If you are using Windows Machine execute below command in your root directoryof the project:
> ./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<imageName>"

### Pull the docker image:
> docker pull cybersploit/jobappusingspringboot:tagname

### Push your own the docker image:
> docker push cybersploit/jobappusingspringboot:tagname

### Run Docker Container
> docker run -it -d p 8080:8080 cybersploit/jobappusingspringboot:tagname