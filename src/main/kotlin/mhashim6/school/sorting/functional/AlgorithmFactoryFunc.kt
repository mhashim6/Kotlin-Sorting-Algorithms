package mhashim6.school.sorting.functional

import mhashim6.school.sorting.isSorted

/**
 *@author mhashim6 on 09/10/2018
 */
typealias AlgorithmFactoryFunc = (IntArray) -> SortingStrategyFunc

val autoPickAlgorithmFactory: AlgorithmFactoryFunc = {
    when {
        it.size <= 1 -> insertionSort
        it.isSorted() -> noSortingStrategy
        it.size >= 10000 -> mergeSort
        else -> insertionSort
    }
}