package domain.participant

import io.kotest.matchers.shouldBe
import ladder.domain.participant.Participant
import ladder.domain.participant.Participants
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
}
