package ladder.domain

class Ladder(val lines: List<Line>) {

    val width: Int
        get() = this.lines.first().width

    init {
        require(lines.isNotEmpty()) { "사다리의 높이는 양수여야 합니다" }
    }

    companion object {
        fun createRandomLadder(width: Int, height: Int): Ladder {
            val lines = List(height) { Line.createRandomLine(width) }
            return Ladder(lines)
        }
    }
}
