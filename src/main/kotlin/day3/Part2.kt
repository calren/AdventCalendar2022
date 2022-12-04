package day3

import java.io.File

fun main(args: Array<String>) {
    sumOfGroups("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day3/input.txt")
}

fun sumOfGroups(fileName: String) {

    var sum = 0

    val lines = mutableListOf<String >()
    File(fileName).forEachLine { lines.add(it) }

    for (i in 0 until lines.size step 3) {
        findCommonItem(lines.get(i), lines.get(i+1), lines.get(i+2))
        sum += getValue(findCommonItem(lines.get(i), lines.get(i+1), lines.get(i+2)))
    }


    print(sum)
}

private fun findCommonItem(s1: String, s2: String, s3: String): Char {
    for (c: Char in s1) {
        for (c2: Char in s2) {
            for (c3: Char in s3)
                if (c == c2 && c2 == c3) {
                    return c
                }
        }
    }

    return '0'
}
