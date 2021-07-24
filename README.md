
# The following application has 5 endpoints

   Create new company

   Get a list of all companies

   Get details about a company

   Update a company

   Add an owner of the company

   Check of Social Security Number
   

# Securing Api with JWT

- Spring Security with JWT can be used to Secure our API.

- Suppose we Develop a Spring Boot Application to expose a Simple REST GET API with mapping  /get.

- Configure Spring Security for JWT. Expose REST POST API with mapping /authenticate using which User will get a valid JSON Web Token. And then allow the user access to the api /get only if it has a valid token

- We will be configuring Spring Security and JWT for performing 2 operations-
Generating JWT - Expose a POST API with mapping /authenticate. On passing correct username and password it will generate a JSON Web Token(JWT)
Validating JWT - If user tries to access GET API with mapping /hello. It will allow access only if request has a valid JSON Web Token(JWT)

## Steps to setup and run the service using docker

- Firstly create the Dockerfile in the SpringBoot Application.
```
  example:
           From openjdk:8
           EXPOSE 8084
           ADD target/spring-boot-docker.jar spring-boot-docker.jar
           ENTRYPOINT ["java","-jar","spring-boot-docker.jar"]

````
- Build the Jar file and add the same to the above DockerFile.
 ```
   example:  

         spring-boot-docker.jar in ADD,ENTRYPOINT Tags above.
  
```

- Once Dockerfile is created then build the docker image by using below command

      docker build -f Dockerfile -t spring-boot-docker


- Check for the Docker Image if it is create.
     
      docker images

- Run the docker image using below command.

      docker run -p 8084:8084 spring-boot-docker
- Once the Docker Image is run Successfully Test in the Browser.

      http://localhost:8084/company/add

## Steps to query the API using curl

- Run the API POST/GET/PUT etc request in Postman .

- Copy the Curl cmd created in Postman like below:
```
  curl --location --request POST 'http://localhost:8080/owner/add' \
  --header 'Content-Type: application/json' \
   --data-raw '{
    "name": "ram",
    "ssn": "aee"
}'
 ```
- Run this curl in Git Bash 
```
  triveni.hiremath@inbl01lap4312 MINGW64 ~/Desktop/Final/company-owner1-main
$ curl --location --request POST 'http://localhost:8080/company/add' \
> --header 'Content-Type: application/json' \
> --data-raw '{
>     "name": "triveni3",
>     "country": "India",
>     "phone": "678989888",
>     "owners": [
>         {
>             "name": "hi",
>             "ssn": "usa"
>         },
>         {
>             "name": "hello",
>             "ssn": "usa1"
>         }
>     ]
> }'
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   391    0   145  100   246   3020   5125 --:--:-- --:--:-- --:--:-- 13033{"id":8,"name":"triveni3","country":"India","phone":678989888,"owners":[{"id":29,"name":"hi","ssn":"usa"},{"id":30,"name":"hello","ssn":"usa1"}]}
```
- Similarly can run all HTTP methods using curl in Git Bash.


