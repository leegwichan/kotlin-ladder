package ladder.domain

class LadderGame(val names: Names, val ladder: Ladder) {

    companion object {

        fun createLadderGame(names: Names, height: Int): LadderGame {
            val ladder = Ladder.createRandomLadder(names.getSize(), height)
            return LadderGame(names, ladder)
        }
    }
}
