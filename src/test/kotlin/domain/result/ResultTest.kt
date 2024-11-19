package domain.result

import io.kotest.matchers.shouldBe
import ladder.domain.result.Result
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `상품 이름은 1글자 이상이어야 합니다`(name: String) {
        val expectation = assertThrows<IllegalArgumentException> { Result(name) }
        expectation.message shouldBe "상품 이름은 공백으로만 이루어 질 수 없습니다"
    }

    @Test
    fun `상품 이름은 특정 글자를 초과할 수 없습니다`() {
        val name = "f".repeat(6)

        val expectation = assertThrows<IllegalArgumentException> { Result(name) }
        expectation.message shouldBe "상품 이름은 5글자를 넘을 수 없습니다"
    }
}
