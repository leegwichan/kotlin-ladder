package domain

import io.kotest.matchers.shouldBe
import ladder.domain.Name
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest{
    @Test
    fun `이름은 5글자를 넘을 수 없습니다`() {
        val expectation = assertThrows<IllegalArgumentException> {
            Name("f".repeat(6))
        }
        expectation.message shouldBe "이름은 5를 넘을 수 없습니다"
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `이름은 공백으로만 이루어질 수 없습니다`(name: String) {
        val expectation = assertThrows<IllegalArgumentException> {
            Name(name)
        }
        expectation.message shouldBe "이름은 공백으로만 이루어 질 수 없습니다"
    }
}
