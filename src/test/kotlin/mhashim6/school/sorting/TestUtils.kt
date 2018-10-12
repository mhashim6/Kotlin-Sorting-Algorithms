package mhashim6.school.sorting

import java.util.*

/**
 *@author mhashim6 on 09/10/2018
 */

private val random = Random()

fun randomIntArray(size: Int, bound: Int = size): IntArray {
    val array = IntArray(size)
    for (i in 0 until size)
        array[i] = random.nextInt(bound)
    return array
}

inline fun <T> T.finally(action: (it: T) -> Unit) = action(this)