package dev4fun.stream.command

import dev4fun.stream.RatingCreated
import dev4fun.stream.client.RatingProducerClient
import picocli.CommandLine
import javax.inject.Inject

@CommandLine.Command(
        name = "rating"
)
class RatingCommand() : Runnable {

    @Inject
    private lateinit var ratingProducerClient: RatingProducerClient

    @CommandLine.Option(
            names = ["--id"]
    )
    private var id: Long = 0

    @CommandLine.Option(
            names = ["--score"]
    )
    private var score: Long = 0

    @CommandLine.Option(
            names = ["--songId"]
    )

    private var songId: Long = 0

    @CommandLine.Option(
            names = ["--userId"]
    )
    private var userId: Long = 0

    override fun run() {

        val ratingEvent = RatingCreated.newBuilder()
                .setId(id)
                .setScore(score)
                .setSongId(songId)
                .setUserId(userId)
                .build()

        ratingProducerClient.send(ratingEvent)
    }
}