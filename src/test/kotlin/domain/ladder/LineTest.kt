package domain.ladder

import io.kotest.matchers.shouldBe
import ladder.domain.ladder.Direction
import ladder.domain.ladder.Line
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LineTest {

    @Test
    fun `라인은 1개 이상의 방향을 가지고 있어야 한다`() {
        val expectation = assertThrows<IllegalArgumentException> { Line(emptyList()) }
        expectation.message shouldBe "한 줄의 방향들은 1개 이상 있어야 합니다"
    }

    @Test
    fun `주어진 길이 만큼의 라인을 만들 수 있다`() {
        val width = 3

        val line = Line.createRandomLine(width)

        line.width shouldBe width
    }

    @ParameterizedTest
    @CsvSource(value = ["0, 1", "1, 0", "2, 2"])
    fun `해당 라인을 지날 때 다음 위치를 알 수 있다`(currentPosition: Int, expectedPosition: Int) {
        val ladder = Line(listOf(Direction.RIGHT, Direction.LEFT, Direction.DOWN))

        val actualPosition = ladder.findNextPosition(currentPosition)

        actualPosition shouldBe expectedPosition
    }
}
