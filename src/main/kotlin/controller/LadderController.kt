package ladder.controller

import ladder.domain.LadderGame
import ladder.domain.participant.Participants
import ladder.domain.result.Results
import ladder.view.InputView
import ladder.view.OutputView

class LadderController(private val inputView: InputView, private val outputView: OutputView) {

    fun start() {
        val inputNames = inputView.inputParticipantNames()
        val participants = Participants.createNames(inputNames)

        val height = inputView.inputLadderHeight()
        val ladderGame = LadderGame.createLadderGame(participants, Results(emptyList()), height)

        outputView.printLadder(ladderGame)
    }
}
