package ladder.domain.ladder

enum class Direction (private val additional: Int) {
    LEFT(-1),
    RIGHT(1),
    DOWN(0),
    ;

    fun next(position: Int): Int {
        return position + additional
    }
}
