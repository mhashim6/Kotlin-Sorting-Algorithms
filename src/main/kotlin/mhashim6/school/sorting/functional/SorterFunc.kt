package mhashim6.school.sorting.functional

import mhashim6.school.sorting.SortingResult
import mhashim6.school.sorting.executionTimeOf

/**
 *@author mhashim6 on 09/10/2018
 */
inline fun IntArray.sortWith(algorithmFactory: AlgorithmFactoryFunc): SortingResult {
    val algorithm = algorithmFactory(this)
    val (sortedArray, time) = executionTimeOf { algorithm(this) }
    return SortingResult.create(sortedArray, time)
}
