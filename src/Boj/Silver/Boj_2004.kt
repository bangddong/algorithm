package Boj.Silver

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class Boj_2004 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        // 순열: n! / (n - m)! * m!
        val five = getFive(n) - getFive(n - m) - getFive(m)
        val two = getTwo(n) - getTwo(n - m) - getTwo(m)

        bw.append(five.coerceAtMost(two).toString())
        bw.flush()
        bw.close()

    }

    fun getFive(n : Int): Int {
        var a = n
        var cnt = 0
        while (a >= 5) {
            cnt += a / 5
            a /= 5
        }

        return cnt
    }

    fun getTwo(n : Int): Int {
        var a = n
        var cnt = 0
        while (a >= 2) {
            cnt += a / 2
            a /= 2
        }

        return cnt
    }
}