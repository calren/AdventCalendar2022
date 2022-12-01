package day1

import java.io.File

fun main(args: Array<String>) {
    findElfCarryingMostCalories("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day1/input.txt")
}

fun findElfCarryingMostCalories(fileName: String) {
    var currentMax = 0

    var currentSum = 0
    File(fileName).forEachLine {
        if (it.isNotBlank()) {
            currentSum += it.toInt()
        } else {
            if (currentSum > currentMax) {
                currentMax = currentSum
            }
            currentSum = 0
        }
    }

    print(currentMax)
}