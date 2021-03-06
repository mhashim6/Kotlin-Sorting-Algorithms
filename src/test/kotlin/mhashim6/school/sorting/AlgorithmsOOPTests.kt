package mhashim6.school.sorting

import mhashim6.school.sorting.oop.AlgorithmFactory
import mhashim6.school.sorting.oop.Sorter
import mhashim6.school.sorting.oop.SortingStrategy
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 *@author mhashim6 on 08/10/2018
 */
class AlgorithmsOOPTests {

    @Test
    fun insertionTest() {
        Sorter.create(algorithm = SortingStrategy.insertion())
                .sort(randomIntArray(size = 10000))
                .also(::println)
                .finally { assertTrue(it.sortedArray.isSorted()) }
    }

    @Test
    fun mergeTest() {
        Sorter.create(algorithm = SortingStrategy.merge())
                .sort(randomIntArray(size = 10000))
                .also(::println)
                .finally { assertTrue(it.sortedArray.isSorted()) }
    }

    @Test
    fun bubbleTest() {
        Sorter.create(algorithm = SortingStrategy.bubble())
                .sort(randomIntArray(size = 10000))
                .also(::println)
                .finally { assertTrue(it.sortedArray.isSorted()) }
    }

    @Test
    fun autoPickMergeTest() {
        val sample = randomIntArray(size = 10000)
        val sorter = Sorter.create(AlgorithmFactory.autoPick(sample))
        assertTrue(sorter.algorithm.javaClass.simpleName == SortingStrategy.merge().javaClass.simpleName)
    }

    @Test
    fun singleElementTest() {
        val sorter = Sorter.create(AlgorithmFactory.autoPick(randomIntArray(size = 1)))
        assertTrue(sorter.algorithm.javaClass.simpleName == SortingStrategy.noSort().javaClass.simpleName)
    }

    @Test
    fun alreadySortedTest() {
        val sorter = Sorter.create(AlgorithmFactory.autoPick(intArrayOf(1, 1, 5, 6, 10, 45, 60, 78)))
        assertTrue(sorter.algorithm.javaClass.simpleName == SortingStrategy.noSort().javaClass.simpleName)
    }
}