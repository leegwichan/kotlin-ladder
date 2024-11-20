package ladder.controller

import ladder.domain.LadderGame
import ladder.domain.participant.Participants
import ladder.domain.result.Results
import ladder.view.InputView
import ladder.view.OutputView

class LadderController(private val inputView: InputView, private val outputView: OutputView) {

    fun start() {
        val ladderGame = inputLadderGame()
        outputView.printLadder(ladderGame)

        while (true) {
            showResult(ladderGame)
        }
    }

    private fun inputLadderGame(): LadderGame {
        val participantNames = inputView.inputParticipantNames()
        val participants = Participants.createByNames(participantNames)

        val resultNames = inputView.inputResultNames()
        val results = Results.createResults(resultNames)

        val height = inputView.inputLadderHeight()
        return LadderGame.createLadderGame(participants, results, height)
    }

    private fun showResult(ladderGame: LadderGame) {
        val input = inputView.inputRequestParticipant()
        if (input == "all") {
            val totalResult = ladderGame.findTotalResult()
            outputView.printTotalResult(totalResult)
            return
        }
        val result = ladderGame.findResult(input)
        outputView.printResult(result)
    }
}
