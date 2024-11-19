package domain.ladder

import io.kotest.matchers.shouldBe
import ladder.domain.ladder.Ladder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LadderTest {

    @Test
    fun `사다리의 높이는 양수여야 한다`() {
        val expectation = assertThrows<IllegalArgumentException> { Ladder(emptyList()) }
        expectation.message shouldBe "사다리의 높이는 양수여야 합니다"
    }
}
