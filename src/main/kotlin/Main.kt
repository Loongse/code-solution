fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")
}

// 229. 求众数 II
fun majorityElement(nums: IntArray): List<Int> {
    val result = arrayListOf<Int>()
    val hashMap = hashMapOf<Int, Int>()
    nums.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    hashMap.forEach {
        if (it.value > nums.size / 3)
            result.add(it.key)
    }
    return result
}
