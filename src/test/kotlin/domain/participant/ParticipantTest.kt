package domain.participant

import io.kotest.matchers.shouldBe
import ladder.domain.participant.Participant
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParticipantTest {

    @Test
    fun `이름은 5글자를 넘을 수 없습니다`() {
        val name = "f".repeat(6)

        val expectation = assertThrows<IllegalArgumentException> { Participant(name) }
        expectation.message shouldBe "이름은 5를 넘을 수 없습니다"
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `이름은 공백으로만 이루어질 수 없습니다`(name: String) {
        val expectation = assertThrows<IllegalArgumentException> { Participant(name) }
        expectation.message shouldBe "이름은 공백으로만 이루어 질 수 없습니다"
    }
}
