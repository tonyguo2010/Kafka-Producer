# Kafka-Producer
The Demo of Java Kafka Producer

To prepare the environment, please refer to:

https://kafka.apache.org/quickstart

Note:
1. Zookeeper server must be launched before Kafka server.

2. To access Kafka server from another computer, please edit "config/server.properties":

 Uncomment #listeners=PLAINTEXT://:9092, make it as: listeners=PLAINTEXT://:9092
 
 Uncomment #advertised.listeners=PLAINTEXT://your.host.name:9092, make it as: advertised.listeners=PLAINTEXT://[the ip to access remotely]:9092
 
3. To avoid the dependencies missing during runtime, please build with command:

  mvn clean compile assembly:single
  
4. Make sure you have enable the port in the firewall list. Kafka's default port is 9092. If you are using Ubuntu, please use the command:
  
  sudo ufw allow 9092

