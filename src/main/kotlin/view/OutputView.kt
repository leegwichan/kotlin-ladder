package ladder.view

import ladder.domain.Direction
import ladder.domain.LadderGame
import ladder.domain.Line
import ladder.domain.Names

class OutputView {
    fun printLadder(ladderGame: LadderGame) {
        println("\n실행결과\n")

        printNames(ladderGame.names)
        ladderGame.ladder.lines.forEach { printLine(it) }
    }

    private fun printNames(names: Names) {
        val printedNames = names.names
            .map { "%-5s".format(it.name) }
            .joinToString(separator = NAME_DELIMITER)
        println(printedNames)
    }

    private fun printLine(line: Line) {
        val printedLine = line.directions
            .map { toPrintedBridge(it) }
            .joinToString(separator = "")
            .trim()
        println(printedLine)
    }

    private fun toPrintedBridge(direction: Direction): String {
        if (direction == Direction.RIGHT) {
            return EXIST_BRIDGE
        }
        return NOT_EXIST_BRIDGE
    }

    companion object {
        private const val NAME_DELIMITER = " "
        private val EXIST_BRIDGE = "|-----"
        private val NOT_EXIST_BRIDGE = "|     "
    }
}
