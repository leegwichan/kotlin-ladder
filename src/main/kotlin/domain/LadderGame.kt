package ladder.domain

import ladder.domain.ladder.Ladder
import ladder.domain.participant.Participants
import ladder.domain.result.Results

class LadderGame(val participants: Participants, val results: Results, val ladder: Ladder) {

    init {
        require(participants.size == results.size) { "참여자 수와 실행 결과 수는 같아야 합니다" }
        require(participants.size == ladder.width) { "참여자 수와 사다리 가로 길이는 같아야 합니다" }
    }

    companion object {

        fun createLadderGame(participants: Participants, results: Results, height: Int): LadderGame {
            val ladder = Ladder.createRandomLadder(participants.size, height)
            return LadderGame(participants, results, ladder)
        }
    }
}
