package ladder.domain

import kotlin.random.Random

object LineGenerator {

    fun generate(size: Int): Line {
        val randomBooleans = random(size)

    }

    fun random(size: Int): List<Boolean> {
        val randomBooleans = mutableListOf<Boolean>()
        val booleanSize = size - 1

        while (randomBooleans.size < booleanSize) {
            val randomBoolean = Random.nextBoolean()
            randomBooleans.add(randomBoolean)
            if (randomBoolean) {
                randomBooleans.add(false)
            }
        }
        return randomBooleans
    }
}
