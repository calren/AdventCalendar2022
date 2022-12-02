package day2

import java.io.File

fun main(args: Array<String>) {
    resultScore2("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day2/input.txt")
}

fun resultScore2(fileName: String) {

    var sumOfScore = 0

    File(fileName).forEachLine {
        val choices = it.split(" ")
        sumOfScore += resultScore2(choices[0], choices[1])
    }

    print(sumOfScore)
}

/**
 * 0 - lose
 * 3 - tie
 * 6 - win
 *
 * A - rock
 * B - paper
 * C - scissors
 *
 * X - lose
 * Y - draw
 * Z - win
 *
 * rock - 1
 * paper - 2
 * scissors - 3
 */
fun resultScore2(opponent: String, result: String): Int {
    // rock
    if (opponent.equals("A")) {
        if (result.equals("X")) { // lose
            // scissors
            return 0 + 3
        } else if (result.equals("Y")) { // draw
            // rock
            return 3 + 1
        } else { // win
            // paper
            return 2 + 6
        }
    }
    // paper
    else if (opponent.equals("B")) {
        if (result.equals("X")) { // lose
            // rock
            return 0 + 1
        } else if (result.equals("Y")) { // draw
            // paper
            return 2 + 3
        } else { // win
            // scissors
            return 3 + 6
        }
    } else
    // scissors
    {
        if (result.equals("X")) { // lose
            // paper
            return 0 + 2
        } else if (result.equals("Y")) { // draw
            // scissors
            return 3 + 3
        } else { // win
            // rock
            return 6 + 1
        }
    }
}