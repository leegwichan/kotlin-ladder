package domain

import io.kotest.matchers.shouldBe
import ladder.domain.Names
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NamesTest {
    @Test
    fun `참여자는 1명 이상이어야 합니다`() {
        val expectation = assertThrows<IllegalArgumentException> {
            Names(mutableListOf())
        }
        expectation.message shouldBe "참여자는 1명 이상 있어야 합니다"
    }
}
