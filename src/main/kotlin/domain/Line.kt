package ladder.domain

import kotlin.random.Random

class Line(val directions: List<Direction>) {

    private fun connect(): Line {
        return Line(directions.dropLast(1) + listOf(Direction.RIGHT, Direction.LEFT))
    }

    private fun notConnect(): Line {
        return Line(directions + Direction.DOWN)
    }

    private fun isLeftNotConnected(): Boolean {
        return directions.last() == Direction.DOWN
    }

    companion object {
        fun createRandomLine(size: Int): Line {
            var line = Line(listOf(Direction.DOWN))
            while (line.directions.size < size) {
                val randomBoolean = Random.nextBoolean()
                if (randomBoolean && line.isLeftNotConnected()) {
                    line = line.connect()
                    continue
                }
                line = line.notConnect()
            }
            return line
        }
    }
}
