package ladder.domain

class LadderGame(val names: Names, val ladder: Ladder) {

    init {
        require(names.getSize() == ladder.width) { "참여자 수와 사다리 가로 길이는 같아야 합니다" }
    }

    companion object {

        fun createLadderGame(names: Names, height: Int): LadderGame {
            val ladder = Ladder.createRandomLadder(names.getSize(), height)
            return LadderGame(names, ladder)
        }
    }
}
