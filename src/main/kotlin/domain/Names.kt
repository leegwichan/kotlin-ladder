package ladder.domain

class Names(names: List<Name>) {
    init {
        require(names.isNotEmpty()) { "참여자는 1명 이상 있어야 합니다" }
    }

    companion object {
        fun createNames(inputNames: List<String>): Names {
            val names = inputNames.map { Name(it) }
            return Names(names)
        }
    }
}
