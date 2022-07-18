# Simple Router
Simple Apache Camel Producer & Consumer that generates random number every 10s.

## Requirements
Apache Camel > 3.5 + Apache Kafka > 2.5 + java > 11 + junit5 + Spring Boot > 2.5

## Environment Setup
Set up kafka env as follow on Linux:

```bash
bin/kafka-topics.sh --create --topic demo-topic --bootstrap-server localhost:9092
```
