package ladder.domain

import ladder.domain.ladder.Ladder
import ladder.domain.participant.Participants

class LadderGame(val participants: Participants, val ladder: Ladder) {

    init {
        require(participants.size == ladder.width) { "참여자 수와 사다리 가로 길이는 같아야 합니다" }
    }

    companion object {

        fun createLadderGame(participants: Participants, height: Int): LadderGame {
            val ladder = Ladder.createRandomLadder(participants.size, height)
            return LadderGame(participants, ladder)
        }
    }
}
