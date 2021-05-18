package dev4fun.stream.command

import dev4fun.stream.SongCreated
import dev4fun.stream.client.SongProducerClient
import picocli.CommandLine
import picocli.CommandLine.Command
import javax.inject.Inject

@Command(name = "song")
class SongCommand () : Runnable {

    @Inject
    lateinit var songProducerClient: SongProducerClient

    @CommandLine.Option(
            names = ["--title"],
            description = ["--description"]
    )
    private var title = ""

    @CommandLine.Option(
            names = ["--id"]
    )
    private var id : Long = 0

    @CommandLine.Option(
            names = ["--duration"]
    )
    private var duration : Long = 0


    override fun run() {

        val songEvent = SongCreated.newBuilder()
                .setDuration(duration)
                .setTitle(title)
                .setId(id)
        .build()

        songProducerClient.send(songEvent)

    }
}