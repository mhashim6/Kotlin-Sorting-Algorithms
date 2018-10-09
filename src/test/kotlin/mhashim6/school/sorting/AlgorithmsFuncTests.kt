package mhashim6.school.sorting

import mhashim6.school.sorting.functional.*
import org.junit.Test

/**
 *@author mhashim6 on 09/10/2018
 */
class AlgorithmsFuncTests {

    @Test
    fun insertionTest() {
        randomIntArray(size = 10000).let { sample ->
            println("original:\n${sample.asList()}")
            println(sample.sortWith { insertionSort })
        }
    }

    @Test
    fun mergeTest() {
        randomIntArray(size = 10000).let { sample ->
            println("original:\n${sample.asList()}")
            println(sample.sortWith { mergeSort })
        }
    }

    @Test
    fun bubbleTest() {
        randomIntArray(size = 10000).let { sample ->
            println("original:\n${sample.asList()}")
            println(sample.sortWith { bubbleSort })
        }
    }

    @Test
    fun autoPickTest() {
        randomIntArray(size = 10000)
                .sortWith(autoPickAlgorithmFactory)
                .also(::println)
    }
}