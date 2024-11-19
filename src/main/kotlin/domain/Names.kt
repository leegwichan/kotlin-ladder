package ladder.domain

class Names(val names: List<Name>) {

    val size: Int
        get() = names.size

    init {
        require(names.isNotEmpty()) { "참여자는 1명 이상 있어야 합니다" }
        require(names.distinct().size == names.size) { "참여자는 중복 될 수 없습니다" }
    }

    companion object {
        fun createNames(inputNames: List<String>): Names {
            val names = inputNames.map { Name(it) }
            return Names(names)
        }
    }
}
