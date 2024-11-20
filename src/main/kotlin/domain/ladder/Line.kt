package ladder.domain.ladder

import kotlin.random.Random

class Line(val directions: List<Direction>) {

    val width: Int
        get() = directions.size

    init {
        require(directions.isNotEmpty()) { "한 줄의 방향들은 1개 이상 있어야 합니다" }
    }

    constructor(direction: Direction) : this(listOf(direction))

    private fun canConnectRight(): Boolean {
        return directions.last() == Direction.DOWN
    }

    private fun connectRight(): Line {
        return Line(directions.dropLast(1) + listOf(Direction.RIGHT, Direction.LEFT))
    }

    private fun notConnectRight(): Line {
        return Line(directions + Direction.DOWN)
    }

    fun findNextPosition(position: Int): Int {
        return directions[position].next(position)
    }

    companion object {
        fun createRandomLine(size: Int): Line {
            var line = Line(Direction.DOWN)
            repeat(size - 1) {
                line = connectLine(line)
            }
            return line
        }

        private fun connectLine(line: Line): Line {
            val randomBoolean = Random.nextBoolean()
            if (randomBoolean && line.canConnectRight()) {
                return line.connectRight()
            }
            return line.notConnectRight()
        }
    }
}
