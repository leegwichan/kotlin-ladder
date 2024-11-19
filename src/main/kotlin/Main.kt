package ladder

import ladder.controller.LadderController
import ladder.view.InputView
import ladder.view.OutputView

fun main() {
    val ladderController = LadderController(InputView, OutputView)

    ladderController.start()
}
