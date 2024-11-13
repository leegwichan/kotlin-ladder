package ladder.view

class InputView {

    fun inputNames(): List<String> {
        return readln().split(NAME_DELIMITER)
    }

    companion object {
        private const val NAME_DELIMITER = ","
    }
}
