package dev4fun.stream.client

import dev4fun.stream.RatingCreated
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.Body

@KafkaClient
interface RatingProducerClient {

    @Topic("rating")
    fun send(@Body payload: RatingCreated)
}