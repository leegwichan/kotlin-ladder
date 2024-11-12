package ladder.domain

class Name(name: String) {
    init {
        require(name.isNotBlank()) { "이름은 공백으로만 이루어 질 수 없습니다" }
        require(name.length <= MAX_NAME_LENGTH) { "이름은 ${MAX_NAME_LENGTH}를 넘을 수 없습니다" }
    }

    companion object {
        private val MAX_NAME_LENGTH = 5;
    }
}
