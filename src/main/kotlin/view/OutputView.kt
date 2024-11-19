package ladder.view

import ladder.domain.*

object OutputView {

    private const val NAME_DELIMITER = " "
    private const val EXIST_BRIDGE = "|-----"
    private const val NOT_EXIST_BRIDGE = "|     "

    fun printLadder(ladderGame: LadderGame) {
        println("\n실행결과\n")

        printNames(ladderGame.names)
        ladderGame.ladder.lines.forEach { printLine(it) }
    }

    private fun printNames(names: Names) {
        val printedNames = names.names
            .joinToString(separator = NAME_DELIMITER) { toPrintedName(it) }
        println(printedNames)
    }

    private fun toPrintedName(it: Name) = "%-5s".format(it.name)

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
