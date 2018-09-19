START KAFKA:
1. bin/zookeeper-server-start.sh config/zookeeper.properties
2. bin/kafka-server-start.sh config/server.properties

CREATE TOPIC :
1. bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic micro-order

CRATE GROUP :
1. bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic micro-order --consumer-property group.id=micro-group-order

LIST GROUP AND TOPIC:
1. bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
2. bin/kafka-topics.sh --list --zookeeper localhost:2181
