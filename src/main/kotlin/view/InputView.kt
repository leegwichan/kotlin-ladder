package ladder.view

class InputView {

    fun inputNames(): List<String> {
        println("참여할 사람 이름을 입력하세요. (이름은 쉼표(${NAME_DELIMITER})로 구분하세요)")
        return readln().split(NAME_DELIMITER)
    }

    fun inputLadderHeight(): Int {
        println("\n최대 사다리 높이는 몇 개인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해야 합니다")
    }

    companion object {
        private const val NAME_DELIMITER = ","
    }
}
