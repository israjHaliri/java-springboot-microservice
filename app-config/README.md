DOCKER INSTRUCTION

1. create Dockerfile
2. build docker : mvn clean install && docker build -f Dockerfile -t app-config .
3. run docker : docker run -p 10000:10000 app-config