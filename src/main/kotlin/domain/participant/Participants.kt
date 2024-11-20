package ladder.domain.participant

class Participants(val participants: List<Participant>) {

    val size: Int
        get() = participants.size

    init {
        require(participants.isNotEmpty()) { "참여자는 1명 이상 있어야 합니다" }
        require(participants.distinct().size == participants.size) { "참여자는 중복 될 수 없습니다" }
    }

    fun findPosition(participantName: String): Int {
        val position = participants.indexOfFirst { it.name == participantName }
        require(position > -1) { "해당 참가자가 존재하지 않습니다" }
        return position
    }

    companion object {
        fun createByNames(names: List<String>): Participants {
            val participants = names.map { Participant(it) }
            return Participants(participants)
        }
    }
}
