## Needed stacks
    + maven 3
    + java8
    + mysql

## Tech stacks
    + maven 3
    + java8
    + mysql
    + springboot
    + netflix eureka

## To get started follow this checklist:
    + create schema micro-account, micro-config, micro-product, micro-order
    + import dump sql file from every module
    + start kafka :
        1. bin/zookeeper-server-start.sh config/zookeeper.properties
        2. bin/kafka-server-start.sh config/server.properties
    + create topic :
        1. bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic micro-order
    + create group :
        1. bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic micro-order --consumer-property group.id=micro-group-order
    + run redis-server
    + run  mvn clean install in all module :
    + run project: java -jar app-config-0.0.1-SNAPSHOT.jar
    + run project: java -jar app-discovery-0.0.1-SNAPSHOT.jar
    + run project: java -jar app-gateway-0.0.1-SNAPSHOT.jar
    + run project: java -jar app-account-0.0.1-SNAPSHOT.jar
    + run project: java -jar app-product-0.0.1-SNAPSHOT.jar
    + run project: java -jar app-order-0.0.1-SNAPSHOT.jar


## COMMON USAGE CLI :

### LIST GROUP AND TOPIC:
    + bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
    + bin/kafka-topics.sh --list --zookeeper localhost:2181

### REDIS :
    + run redis : redis-server
    + run cli : redis cli
    + list key : keys *
    + see log redis : MONITOR
