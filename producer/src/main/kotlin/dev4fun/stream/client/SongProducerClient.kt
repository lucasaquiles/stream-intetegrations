package dev4fun.stream.client

import dev4fun.stream.SongCreated
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.Body

@KafkaClient
interface SongProducerClient {

    @Topic("song-created")
    fun send(@Body payload: SongCreated)
}