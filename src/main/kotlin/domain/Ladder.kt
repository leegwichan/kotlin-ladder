package ladder.domain

class Ladder(val lines: List<Line>) {
    init {
        require(lines.isNotEmpty()) { "사다리의 높이는 양수여야 합니다" }
    }

    companion object {
        fun createLadder(width: Int, height: Int): Ladder {
            val lines = List(height) { Line.createRandomLine(width) }
            return Ladder(lines)
        }
    }
}
