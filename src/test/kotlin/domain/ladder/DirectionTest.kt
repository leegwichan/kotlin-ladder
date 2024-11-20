package domain.ladder

import io.kotest.matchers.shouldBe
import ladder.domain.ladder.Direction
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = ["1, 0, LEFT", "1, 1, DOWN", "1, 2, RIGHT"])
    fun `방향에 따라 다음 위치를 구할 수 있다`(currentPosition: Int, expected: Int, direction: Direction) {
        val actual = direction.next(currentPosition)

        actual shouldBe expected
    }
}
