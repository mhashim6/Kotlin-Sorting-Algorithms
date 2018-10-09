package mhashim6.school.sorting.oop

import mhashim6.school.sorting.isSorted

/**
 *
 *@author mhashim6 on 09/10/2018
 */
interface AlgorithmFactory {
    val array: IntArray
    fun pickAlgorithm(): SortingStrategy

    companion object Factory {
        fun create(array: IntArray): AlgorithmFactory = DefaultAlgorithmFactory(array)
    }
}

class DefaultAlgorithmFactory(override val array: IntArray) : AlgorithmFactory {
    override fun pickAlgorithm(): SortingStrategy {
        return when {
            array.size <= 1 -> SortingStrategy.noSort()
            array.isSorted() -> SortingStrategy.noSort()
            array.size > 10000 -> SortingStrategy.merge()
            else -> SortingStrategy.insertion()
        }
    }
}