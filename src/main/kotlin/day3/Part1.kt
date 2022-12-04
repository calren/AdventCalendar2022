package day3

import java.io.File

    fun main(args: Array<String>) {
        sumOfAllCommons("/Users/carenc/Desktop/AdventCode2022/src/main/kotlin/day3/input.txt")
    }

    fun sumOfAllCommons(fileName: String) {

        var sum = 0

        File(fileName).forEachLine {
            val length = it.length
            val commonItem = findCommonItem(it.substring(0, length / 2), it.substring(length / 2, length))
            sum += getValue(commonItem)
        }

        print(sum)
    }

    private fun findCommonItem(s1: String, s2: String): Char {
        for (c: Char in s1) {
            for (c2: Char in s2) {
                if (c == c2) {
                    return c
                }
            }
        }

        return '0'
    }

    fun getValue(c: Char): Int {
        val pre = c.toInt() - 96
        return if (pre < 1) {
            c.toInt() - 38
        } else {
            pre
        }
    }
