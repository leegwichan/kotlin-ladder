package domain.result

import io.kotest.matchers.shouldBe
import ladder.domain.result.Results
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ResultsTest {

    @Test
    fun `실행 결과는 1개 이상 있어야 합니다`() {
        val expectation = assertThrows<IllegalArgumentException> { Results(emptyList()) }
        expectation.message shouldBe "실행 결과는 적어도 1개 이상 있어야 합니다"
    }
}
