package ladder.view

import ladder.domain.LadderGame
import ladder.domain.ladder.Direction
import ladder.domain.ladder.Line

object OutputView {

    private const val NAME_DELIMITER = " "
    private const val EXIST_BRIDGE = "|-----"
    private const val NOT_EXIST_BRIDGE = "|     "

    fun printLadder(ladderGame: LadderGame) {
        println("\n실행결과\n")

        printNames(ladderGame.participants.names)
        ladderGame.ladder.lines.forEach { printLine(it) }
        printNames(ladderGame.results.names)
    }

    private fun printNames(names: List<String>) {
        val printedNames = names
            .joinToString(separator = NAME_DELIMITER) { toPrintedName(it) }
        println(printedNames)
    }

    private fun toPrintedName(it: String) = "%-5s".format(it)

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

    fun printResult(result: String) {
        println("\n실행 결과")
        println(result)
    }

    fun printTotalResult(results: Map<String, String>) {
        println("\n실행 결과")
        results.forEach { (key, value) -> println("$key : $value") }
    }
}
