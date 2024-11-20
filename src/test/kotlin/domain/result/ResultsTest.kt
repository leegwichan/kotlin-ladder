package domain.result

import io.kotest.matchers.shouldBe
import ladder.domain.result.Results
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ResultsTest {

    @Test
    fun `실행 결과는 1개 이상 있어야 합니다`() {
        val expectation = assertThrows<IllegalArgumentException> { Results(emptyList()) }
        expectation.message shouldBe "실행 결과는 적어도 1개 이상 있어야 합니다"
    }

    @ParameterizedTest
    @CsvSource(value = ["0, first", "1, secon", "2, third"])
    fun `각 위치에 있는 실행 결과 이름을 찾을 수 있다`(position: Int, expected: String) {
        val results = Results.createResults(listOf("first", "secon", "third"))

        val actual = results.getResultName(position)

        actual shouldBe expected
    }
}
