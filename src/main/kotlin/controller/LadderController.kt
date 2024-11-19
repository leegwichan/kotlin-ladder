package ladder.controller

import ladder.domain.LadderGame
import ladder.domain.participant.Participants
import ladder.view.InputView
import ladder.view.OutputView

class LadderController(private val inputView: InputView, private val outputView: OutputView) {

    fun start() {
        val inputNames = inputView.inputParticipantNames()
        val participants = Participants.createNames(inputNames)

        val height = inputView.inputLadderHeight()
        val ladderGame = LadderGame.createLadderGame(participants, height)

        outputView.printLadder(ladderGame)
    }
}
