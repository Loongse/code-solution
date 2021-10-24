import kotlin.math.min

class ShoppingOffers {
    fun shoppingOffers(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int {
        val data = ArrayList<IntArray>()
        for (i in price.indices) {
            val current = IntArray(needs.size + 1)
            current[i] = 1
            current[needs.size] = price[i]
            data.add(current)
        }
        special.forEach {
            data.add(it.toIntArray())
        }
        return search(needs.toIntArray(), data)
    }

    private var memory = HashMap<String, Int>()
    private fun search(needs: IntArray, data: ArrayList<IntArray>): Int {
        var ans = Int.MAX_VALUE
        if (needs.sum() == 0) {
            return 0
        }
        val key = needs.toList().toString()
        if (memory.contains(key)) {
            return memory[key]!!
        }
        for (item in data) {
            val currentNeeds = IntArray(needs.size)
            var isOverShip = false
            for (i in currentNeeds.indices) {
                currentNeeds[i] = needs[i] - item[i]
                if (currentNeeds[i] < 0) {
                    isOverShip = true
                }
            }
            if (isOverShip)
                continue
            ans = min(ans, item[needs.size] + search(currentNeeds, data))
        }
        memory[key] = ans
        return ans
    }
}