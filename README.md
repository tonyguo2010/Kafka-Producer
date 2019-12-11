# Kafka-Producer
The Demo of Java Kafka Producer

To prepare the environment, please refer to:
https://kafka.apache.org/quickstart

Note:
1. Zookeeper server must be launched before Kafka server.
2. To access Kafka server from another computer, please edit "config/server.properties":
 Uncomment #listeners=PLAINTEXT://:9092, make it as: listeners=PLAINTEXT://:9092
 Uncomment #advertised.listeners=PLAINTEXT://your.host.name:9092, make it as: advertised.listeners=PLAINTEXT://[the ip to access remotely]:9092
