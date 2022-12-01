package day1

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    findTop3WithPQ("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day1/input.txt")
}

fun findTop3ElfCarryingMostCalories(fileName: String) {

    var listOfCalories = mutableListOf<Int>()

    var currentSum = 0
    File(fileName).forEachLine {
        if (it.isNotBlank()) {
            currentSum += it.toInt()
        } else {
            listOfCalories.add(currentSum)
            currentSum = 0
        }
    }

    val sorted = listOfCalories.sortedDescending()

    print(sorted.get(0) + sorted.get(1) + sorted.get(2))
}

fun findTop3WithPQ(fileName: String) {
    val top3: PriorityQueue<Int> = PriorityQueue<Int>(3, Collections.reverseOrder())

    var currentSum = 0
    File(fileName).forEachLine {
        if (it.isNotBlank()) {
            currentSum += it.toInt()
        } else {
            top3.add(currentSum)
            currentSum = 0
        }
    }

    var finalTop3Sum = 0
    for (i in 1..3) {
        finalTop3Sum += top3.poll()
    }

    print(finalTop3Sum)
}