package ladder.domain

class LadderGame(val names: Names, val ladder: Ladder) {

    companion object {

        fun createRandomLadderGame(names: Names, height: Int): LadderGame {
            val ladder = Ladder.createLadder(names.getSize(), height)
            return LadderGame(names, ladder)
        }
    }
}
