package mhashim6.school.sorting

import java.util.*

/**
 *@author mhashim6 on 08/10/2018
 */

/**
 * measures the running time of the given action in milliseconds.
 * @return Pair of the result of the action and it's execution time.
 */
inline fun <T> executionTimeOf(action: () -> T): Pair<T, Long> {
    val start = System.currentTimeMillis()
    val result = action()
    val end = System.currentTimeMillis()
    return result to (end - start)
}

/**
 * swaps the element in index j with the element in index i.
 */
fun IntArray.swap(i: Int, j: Int) {
    val temp = this[j]
    this[j] = this[i]
    this[i] = temp
}

fun IntArray.isSorted(): Boolean {
    for (i in 0 until this.size)
        if (this[i] > this[i + 1])
            return false
    return true
}

private val random = Random()
fun randomIntArray(size: Int, bound: Int = size): IntArray {
    val array = IntArray(size)
    for (i in 0 until size)
        array[i] = random.nextInt(bound)
    return array
}
