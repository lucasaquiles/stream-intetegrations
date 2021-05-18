package dev4fun.stream

import dev4fun.stream.command.PlayerCommand
import dev4fun.stream.command.SongCommand
import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(name = "producer", description = ["..."],
        mixinStandardHelpOptions = true,
        subcommands = [
            PlayerCommand::class,
            SongCommand::class
        ]
)
class ProducerCommand : Runnable {

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose : Boolean = false

    override fun run() {

        if (verbose) {
            println("Hi!")
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(ProducerCommand::class.java, *args)
        }
    }
}
