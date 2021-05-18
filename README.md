docker exec -it <ksql_cli_container_id> /bin/bash
ksql http://ksql-server:8088

SET 'auto.offset.reset' = 'earliest'

ksql> CREATE STREAM player_stream (SONG_ID INT, STATUS VARCHAR, USER_ID INT, CREATED_AT VARCHAR) WITH (KAFKA_TOPIC='player-updated', VALUE_FORMAT='AVRO');

ksql> CREATE STREAM SONG_STREAM (SONG_ID INT, TITLE VARCHAR) WITH (KAFKA_TOPIC='song-created', VALUE_FORMAT='AVRO')