mvn -U clean install
docker build -t hotel:latest -f Dockerfile .
docker container run -p 8080:8080 hotel

exit 1
