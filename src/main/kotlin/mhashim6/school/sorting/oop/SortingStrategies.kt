package mhashim6.school.sorting.oop

import mhashim6.school.sorting.swap

/** could be modified using generics to sort any kind of a comparable object,
 *  but for the sake of performance and simplicity, an IntArray will do.
 *  @author mhashim6 on 08/10/2018
 */
interface SortingStrategy {
    fun sort(array: IntArray): IntArray

    companion object Strategies {
        fun insertion(): SortingStrategy = InsertionStrategy()
        fun merge(): SortingStrategy = MergeStrategy()
        fun bubble(): SortingStrategy = BubbleStrategy()
        fun recursiveMerge(): SortingStrategy = RecursiveMergeStrategy()
        fun noSort(): SortingStrategy = NoSortingStrategy()
    }
}

/**
 * Insertion sort algorithm.
 */
private class InsertionStrategy : SortingStrategy {
    override fun sort(array: IntArray): IntArray {
        for (i in 0 until array.size)
            for (j in i downTo 1)
                if (array[j] < array[j - 1])
                    array.swap(j, j - 1)
        return array
    }
}

/**
 * Merge sort algorithm.
 */
private class MergeStrategy : SortingStrategy {
    override fun sort(array: IntArray): IntArray {
        return if (array.size == 1)
            array
        else {
            val middle = (array.size / 2)
            val left = sort(array.sliceArray(0 until middle))
            val right = sort(array.sliceArray(middle until array.size))
            merge(left, right)
        }
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        val size = left.size + right.size
        val merged = IntArray(size)

        var iLeft = 0
        var iRight = 0
        var iMerged = 0

        while (iLeft < left.size && iRight < right.size) {
            if (left[iLeft] < right[iRight]) {
                merged[iMerged] = left[iLeft]
                iLeft++
            } else {
                merged[iMerged] = right[iRight]
                iRight++
            }
            iMerged++
        }
        System.arraycopy(left, iLeft, merged, iMerged, left.size - iLeft)
        System.arraycopy(right, iRight, merged, iMerged, right.size - iRight)
        return merged
    }
}

/**
 * Bubble sort algorithm.
 */
private class BubbleStrategy : SortingStrategy {
    override fun sort(array: IntArray): IntArray {
        for (i in 0 until array.size)
            for (j in 0 until (array.size - 1))
                if (array[j] > array[j + 1])
                    array.swap(j, j + 1)
        return array
    }
}

/**
 * Merge sort algorithm that uses recursion in it's merge method.
 * horrible performance on the jvm, but it should be fine in actual functional languages.
 */
private class RecursiveMergeStrategy : SortingStrategy {
    override fun sort(array: IntArray): IntArray {
        return if (array.size == 1)
            array
        else {
            val middle = (array.size / 2)
            val left = sort(array.sliceArray(0 until middle))
            val right = sort(array.sliceArray(middle until array.size))
            merge(left, right)
        }
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        return when {
            left.isEmpty() -> right
            right.isEmpty() -> left
            left.first() < right.first() ->
                intArrayOf(left.first()) + merge(left.sliceArray(1 until left.size), right)
            else ->
                intArrayOf(right.first()) + merge(left, right.sliceArray(1 until right.size))
        }
    }
}

/**
 * convenient strategy that returns the the same input without sorting.
 */
private class NoSortingStrategy : SortingStrategy {
    override fun sort(array: IntArray) = array
}