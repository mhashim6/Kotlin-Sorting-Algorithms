package mhashim6.school.sorting

import mhashim6.school.sorting.oop.AlgorithmFactory
import mhashim6.school.sorting.oop.Sorter
import mhashim6.school.sorting.oop.SortingStrategy
import org.junit.Assert
import org.junit.Test

/**
 *@author mhashim6 on 08/10/2018
 */
class AlgorithmsOOPTests {

    @Test
    fun insertionTest() {
        val sorter = Sorter.create(algorithm = SortingStrategy.insertion())
        val sample = randomIntArray(size = 10000)

        println("original:\n${sample.asList()}")
        println(sorter.sort(sample))
    }

    @Test
    fun mergeTest() {
        val sorter = Sorter.create(algorithm = SortingStrategy.merge())
        val sample = randomIntArray(size = 10000)

        println("original:\n${sample.asList()}")
        println(sorter.sort(sample))
    }

    @Test
    fun bubbleTest() {
        val sorter = Sorter.create(algorithm = SortingStrategy.bubble())
        val sample = randomIntArray(size = 10000)

        println("original:\n${sample.asList()}")
        println(sorter.sort(sample))
    }

    @Test
    fun autoPickTest() {
        val sample = randomIntArray(size = 10000)
        var sorter = Sorter.create(AlgorithmFactory.autoPick(sample))
        Assert.assertTrue(sorter.algorithm.javaClass.simpleName == SortingStrategy.merge().javaClass.simpleName)
        sorter.sort(sample).let(::println)

        sorter = Sorter.create(AlgorithmFactory.autoPick(randomIntArray(size = 1)))
        Assert.assertTrue(sorter.algorithm.javaClass.simpleName == SortingStrategy.noSort().javaClass.simpleName)

        sorter = Sorter.create(AlgorithmFactory.autoPick(intArrayOf(1, 1, 5, 6, 10, 45, 60, 78)))
        Assert.assertTrue(sorter.algorithm.javaClass.simpleName == SortingStrategy.noSort().javaClass.simpleName)
    }
}