package ladder.domain.result

class Results(private val results: List<Result>) {

    val names
        get() = results.map { it.name }

    init {
        require(results.isNotEmpty()) { "실행 결과는 적어도 1개 이상 있어야 합니다" }
    }

    val size
        get() = results.size

    fun getResultName(position: Int): String {
        return results[position].name
    }

    companion object {

        fun createResults(names: List<String>): Results {
            val results = names.map { Result(it) }
            return Results(results)
        }
    }
}
