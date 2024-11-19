package ladder.view

import ladder.domain.*
import ladder.domain.ladder.Direction
import ladder.domain.participant.Participant
import ladder.domain.participant.Participants

object OutputView {

    private const val NAME_DELIMITER = " "
    private const val EXIST_BRIDGE = "|-----"
    private const val NOT_EXIST_BRIDGE = "|     "

    fun printLadder(ladderGame: LadderGame) {
        println("\n실행결과\n")

        printNames(ladderGame.participants)
        ladderGame.ladder.lines.forEach { printLine(it) }
    }

    private fun printNames(participants: Participants) {
        val printedNames = participants.participants
            .joinToString(separator = NAME_DELIMITER) { toPrintedName(it) }
        println(printedNames)
    }

    private fun toPrintedName(it: Participant) = "%-5s".format(it.name)

    private fun printLine(line: Line) {
        val printedLine = line.directions
            .joinToString(separator = "") { toPrintedBridge(it) }.trim()
        println(printedLine)
    }

    private fun toPrintedBridge(direction: Direction): String {
        if (direction == Direction.RIGHT) {
            return EXIST_BRIDGE
        }
        return NOT_EXIST_BRIDGE
    }
}
