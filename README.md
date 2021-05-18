Cenários com streams usando Kafka e KSQL

* executar o docker-compose 

`docker-compose -f kafka-stack.yml up`

* construir o jar do publisher no kafka

`cd producer | ./gradlew build`

* executar os sctrips para publicar no kafka 

`sh init.sh <numero_repeticoes>`
`sh init-plalist.sh <numero_repeticoes>`


*** exemplos exploratorios com os registros nos topicos
```
docker exec -it <ksql_cli_container_id> /bin/bash
ksql http://ksql-server:8088

SET 'auto.offset.reset' = 'earliest'

ksql> CREATE STREAM player_stream (SONG_ID INT, STATUS VARCHAR, USER_ID INT, CREATED_AT VARCHAR) WITH (KAFKA_TOPIC='player-updated', VALUE_FORMAT='AVRO');

ksql> CREATE STREAM SONG_STREAM (SONG_ID INT, TITLE VARCHAR) WITH (KAFKA_TOPIC='song-created', VALUE_FORMAT='AVRO')
```