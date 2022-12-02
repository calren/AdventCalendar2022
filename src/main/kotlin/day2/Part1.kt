package day2

import java.io.File

fun main(args: Array<String>) {
    calculateScore("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day2/input.txt")
}

fun calculateScore(fileName: String) {

    var sumOfScore = 0

    File(fileName).forEachLine {
        val choices = it.split(" ")
        sumOfScore += getScore(choices[1]) + resultScore(choices[0], choices[1])
    }

    print(sumOfScore)
}

fun getScore(choice: String): Int {
    if (choice.equals("X")) {
        return 1
    } else if (choice.equals("Y")) {
        return 2
    } else {
        return 3
    }
}

/**
 * 0 - lose
 * 3 - tie
 * 6 - win
 *
 * X - rock
 * Y - paper
 * Z - scissors
 *
 * A - rock
 * B - paper
 * C - scissors
 */
fun resultScore(opponent: String, player: String): Int {
    if (opponent.equals("A")) {
        if (player.equals("X")) {
            return 3
        } else if (player.equals("Y")) {
            return 6
        } else {
            return 0
        }
    } else if (opponent.equals("B")) {
        if (player.equals("X")) {
            return 0
        } else if (player.equals("Y")) {
            return 3
        } else {
            return 6
        }
    } else {
        if (player.equals("X")) {
            return 6
        } else if (player.equals("Y")) {
            return 0
        } else {
            return 3
        }
    }
}
