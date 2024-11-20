package domain

import io.kotest.matchers.shouldBe
import ladder.domain.LadderGame
import ladder.domain.ladder.Direction
import ladder.domain.ladder.Ladder
import ladder.domain.ladder.Line
import ladder.domain.participant.Participant
import ladder.domain.participant.Participants
import ladder.domain.result.Result
import ladder.domain.result.Results
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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

    @ParameterizedTest
    @CsvSource(value = ["one, third", "two, first", "three, secon"])
    fun `참여자 이름에 해당하는 실행 결과를 반환할 수 있다`(participantName: String, expected: String) {
        /*
          one   two   three
          |-----|     |
          |     |-----|
          first secon third
        */
        val participants = Participants.createByNames(listOf("one", "two", "three"))
        val results = Results.createResults(listOf("first", "secon", "third"))
        val line1 = Line(listOf(Direction.RIGHT, Direction.LEFT, Direction.DOWN))
        val line2 = Line(listOf(Direction.DOWN, Direction.RIGHT, Direction.LEFT))
        val ladder = Ladder(listOf(line1, line2))
        val ladderGame = LadderGame(participants, results, ladder)

        val actual = ladderGame.findResult(participantName)

        actual shouldBe expected
    }

    @Test
    fun `사다리 게임의 전체 실행 결과를 반환할 수 있다`() {
        /*
          one   two   three
          |-----|     |
          |     |-----|
          first secon third
        */
        val participants = Participants.createByNames(listOf("one", "two", "three"))
        val results = Results.createResults(listOf("first", "secon", "third"))
        val line1 = Line(listOf(Direction.RIGHT, Direction.LEFT, Direction.DOWN))
        val line2 = Line(listOf(Direction.DOWN, Direction.RIGHT, Direction.LEFT))
        val ladder = Ladder(listOf(line1, line2))
        val ladderGame = LadderGame(participants, results, ladder)
        val expected = mapOf("one" to "third", "two" to "first", "three" to "secon")

        val actual = ladderGame.findTotalResult()

        actual shouldBe expected
    }
}
