package domain.ladder

import io.kotest.matchers.shouldBe
import ladder.domain.ladder.Direction
import ladder.domain.ladder.Ladder
import ladder.domain.ladder.Line
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LadderTest {

    @Test
    fun `사다리의 높이는 양수여야 한다`() {
        val expectation = assertThrows<IllegalArgumentException> { Ladder(emptyList()) }
        expectation.message shouldBe "사다리의 높이는 양수여야 합니다"
    }


    @ParameterizedTest
    @CsvSource(value = ["0, 2", "1, 0", "2, 1"])
    fun `참여자 위치에 따라 결과 위치를 찾을 수 있다`(participantPosition: Int, expectedPosition: Int) {
        /*
          |-----|     |
          |     |-----|
        */
        val line1 = Line(listOf(Direction.RIGHT, Direction.LEFT, Direction.DOWN))
        val line2 = Line(listOf(Direction.DOWN, Direction.RIGHT, Direction.LEFT))
        val ladder = Ladder(listOf(line1, line2))

        val actual = ladder.findResultPosition(participantPosition)

        actual shouldBe expectedPosition
    }
}
