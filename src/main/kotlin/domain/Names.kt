package ladder.domain

class Names(private val names: List<Name>) {
    init {
        require(names.isNotEmpty()) { "참여자는 1명 이상 있어야 합니다" }
        require(names.distinct().size == names.size) { "참여자는 중복 될 수 없습니다" }
    }

    fun getSize(): Int {
        return names.size
    }

    companion object {
        fun createNames(inputNames: List<String>): Names {
            val names = inputNames.map { Name(it) }
            return Names(names)
        }
    }
}
