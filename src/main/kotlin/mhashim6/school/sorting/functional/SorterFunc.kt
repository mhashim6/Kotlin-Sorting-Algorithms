package mhashim6.school.sorting.functional

import mhashim6.school.sorting.SortingResult
import mhashim6.school.sorting.executionTimeOf

/**
 *@author mhashim6 on 09/10/2018
 */

fun IntArray.sort(array: IntArray, algorithmFactory: AlgorithmFactoryFunc): SortingResult {
    val algorithm = algorithmFactory(array)
    val (sortedArray, time) = executionTimeOf { algorithm(array) }
    return SortingResult.create(sortedArray, time)
}
