package domain.participant

import io.kotest.matchers.shouldBe
import ladder.domain.participant.Participant
import ladder.domain.participant.Participants
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ParticipantsTest {

    @Test
    fun `참여자는 1명 이상이어야 합니다`() {
        val expectation = assertThrows<IllegalArgumentException> { Participants(emptyList()) }
        expectation.message shouldBe "참여자는 1명 이상 있어야 합니다"
    }

    @Test
    fun `중복된 참여자가 있으면 안된다`() {
        val participants = listOf(Participant("bito"), Participant("keo"), Participant("bito"))

        val expectation = assertThrows<IllegalArgumentException> { Participants(participants) }
        expectation.message shouldBe "참여자는 중복 될 수 없습니다"
    }

    @ParameterizedTest
    @CsvSource(value = ["one, 0", "two, 1", "three, 2"])
    fun `참여자 이름을 통해 위치를 찾을 수 있다`(name: String, expected: Int) {
        val participants = Participants.createByNames(listOf("one", "two", "three"))

        val actual = participants.findPosition(name)

        actual shouldBe expected
    }

    @Test
    fun `참여자 이름을 통해 위치를 찾을 때, 해당 참여자가 없다면 예외를 던진다`() {
        val participants = Participants.createByNames(listOf("one", "two", "three"))
        val notExistName = "noOne"

        val expectation = assertThrows<IllegalArgumentException> { participants.findPosition(notExistName) }
        expectation.message shouldBe "해당 참가자가 존재하지 않습니다"
    }
}
