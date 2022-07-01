# application-without-dc
created only Dockerfile and linked both postgres container and customer-application image using --link in docker.

#first postgres container need to be running in docker desktop.
docker run -d --name postgresdb -p 5432:5432 -e POSTGRES_USER=(giveanyname) -e POSTGRES_PASSWORD=(giveanypassword) -e POSTGRES_DB=mydb postgres

#creating container name for springboot image and linking it with postgres container
docker run -d -p 8080:8080 --name (springboot container name) --link (postgres container name:tag) (springboot image name:tag) (ENTRYPOINT from Dockerfile)

docker run -d -p 8080:8080 --name container --link postgresmydb:latest cs-w/o-dc:latest java -jar app.jar

