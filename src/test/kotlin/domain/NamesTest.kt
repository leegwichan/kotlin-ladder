package domain

import io.kotest.matchers.shouldBe
import ladder.domain.Name
import ladder.domain.Names
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NamesTest {

    @Test
    fun `참여자는 1명 이상이어야 합니다`() {
        val expectation = assertThrows<IllegalArgumentException> { Names(emptyList()) }
        expectation.message shouldBe "참여자는 1명 이상 있어야 합니다"
    }

    @Test
    fun `중복된 참여자가 있으면 안된다`() {
        val names = listOf(Name("bito"), Name("keo"), Name("bito"))

        val expectation = assertThrows<IllegalArgumentException> { Names(names) }
        expectation.message shouldBe "참여자는 중복 될 수 없습니다"

    }
}
