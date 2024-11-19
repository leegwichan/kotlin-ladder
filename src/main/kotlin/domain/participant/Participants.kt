package ladder.domain.participant

class Participants(val participants: List<Participant>) {

    val size: Int
        get() = participants.size

    init {
        require(participants.isNotEmpty()) { "참여자는 1명 이상 있어야 합니다" }
        require(participants.distinct().size == participants.size) { "참여자는 중복 될 수 없습니다" }
    }

    companion object {
        fun createNames(names: List<String>): Participants {
            val participants = names.map { Participant(it) }
            return Participants(participants)
        }
    }
}
