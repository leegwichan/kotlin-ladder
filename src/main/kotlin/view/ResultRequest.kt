package ladder.view

data class ResultRequest(val input: String) {

    fun isRequestTotalResult(): Boolean {
        return input == REQUEST_TOTAL_RESULT_INPUT
    }

    companion object {
        private const val REQUEST_TOTAL_RESULT_INPUT = "all"
    }
}
