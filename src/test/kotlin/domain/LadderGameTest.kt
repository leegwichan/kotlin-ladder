package domain

import io.kotest.matchers.shouldBe
import ladder.domain.LadderGame
import ladder.domain.ladder.Ladder
import ladder.domain.participant.Participant
import ladder.domain.participant.Participants
import ladder.domain.result.Result
import ladder.domain.result.Results
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LadderGameTest {

    @Test
    fun `참여자 수와 실행 결과 수는 같아야 한다`() {
        val participants = Participants(listOf(Participant("keo"), Participant("chan")))
        val results = Results(listOf(Result("꽝")))
        val ladder = Ladder.createRandomLadder(2, 5)

        val expectation = assertThrows<IllegalArgumentException> { LadderGame(participants, results, ladder) }
        expectation.message shouldBe "참여자 수와 실행 결과 수는 같아야 합니다"
    }

    @Test
    fun `참여자 수와 사다리 가로 길이는 같아야 한다`() {
        val participants = Participants(listOf(Participant("keo"), Participant("chan")))
        val results = Results(listOf(Result("꽝"), Result("2000")))
        val ladder = Ladder.createRandomLadder(3, 5)

        val expectation = assertThrows<IllegalArgumentException> { LadderGame(participants, results, ladder) }
        expectation.message shouldBe "참여자 수와 사다리 가로 길이는 같아야 합니다"
    }
}
