package dev4fun.stream.client

import dev4fun.stream.Player
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.Body

@KafkaClient
interface PlayerProducerClient {

    @Topic("player-updated")
    fun send(@Body payload: Player)
}
