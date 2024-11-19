package domain

import io.kotest.matchers.shouldBe
import ladder.domain.Line
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
}
