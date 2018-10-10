package mhashim6.school.sorting

/**
 *@author mhashim6 on 08/10/2018
 */

interface SortingResult {
    val sortedArray: IntArray
    val executionTime: Long

    companion object Factory {
        fun create(sortedArray: IntArray, interval: Long): SortingResult = SortingResultImpl(sortedArray, interval)
    }
}

private class SortingResultImpl(override val sortedArray: IntArray, override val executionTime: Long) : SortingResult {
    override fun toString(): String {
        return "sorted:\n${sortedArray.asList()}\ntime: $executionTime milliseconds."
    }
}