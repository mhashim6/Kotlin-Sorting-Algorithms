package mhashim6.school.sorting

import mhashim6.school.sorting.oop.Sorter
import mhashim6.school.sorting.oop.SortingStrategy
import org.junit.Test

/**
 *@author mhashim6 on 08/10/2018
 */
class AlgorithmsOOPTests {

    private val sorter = Sorter.create(algorithm = SortingStrategy.insertion())
    private val sample = randomIntArray(size = 10000)

    @Test
    fun insertionTest() {
        println("original:\n${sample.asList()}")
        println(sorter.sort(sample))
    }

    @Test
    fun mergeTest() {
        println("original:\n${sample.asList()}")
        val result = sorter.apply { algorithm = SortingStrategy.merge() }.sort(sample)
        println(result)
    }

    @Test
    fun bubbleTest() {
        println("original:\n${sample.asList()}")
        val result = sorter.apply { algorithm = SortingStrategy.bubble() }.sort(sample)
        println(result)
    }

    @Test
    fun recursiveMergeTest() {
        println("original:\n${sample.asList()}")
        val result = sorter.apply { algorithm = SortingStrategy.recursiveMerge() }.sort(sample)
        println(result)
    }
}