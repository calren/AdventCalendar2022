package day1

import java.io.File

fun main(args: Array<String>) {
    findTop3ElfCarryingMostCalories("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day1/input.txt")
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