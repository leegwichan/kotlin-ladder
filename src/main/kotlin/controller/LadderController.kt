package ladder.controller

import ladder.domain.LadderGame
import ladder.domain.Names
import ladder.view.InputView
import ladder.view.OutputView

class LadderController(private val inputView: InputView, private val outputView: OutputView) {

    fun start() {
        val inputNames = inputView.inputNames()
        val names = Names.createNames(inputNames)

        val height = inputView.inputLadderHeight()
        val ladderGame = LadderGame.createRandomLadderGame(names, height)

        outputView.printLadder(ladderGame)
    }
}
