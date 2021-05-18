package dev4fun.stream.command

import dev4fun.stream.Player
import dev4fun.stream.client.PlayerProducerClient
import picocli.CommandLine
import javax.inject.Inject

@CommandLine.Command( helpCommand = true, name = "player" )
class PlayerCommand() : Runnable{

    @Inject
    lateinit var playerProducerClient: PlayerProducerClient

    @CommandLine.Option( names = ["--accountId"], description = [""] )
    private var accountId: String = ""

    @CommandLine.Option( names = ["--songId"], description = [""] )
    private var songId: String = ""

    @CommandLine.Option( names = ["--startedAt"], description = [""] )
    private var startedAt: String = ""

    @CommandLine.Option( names = ["--status"], description = [""] )
    private var status: String = ""

    override fun run() {

        val playerEvent = Player.newBuilder()
                .setSongId(songId.toLong())
                .setUserId(accountId.toLong())
                .setStatus(status)
                .setStartedAt(startedAt)
                .build()

        playerProducerClient.send(playerEvent)
    }
}