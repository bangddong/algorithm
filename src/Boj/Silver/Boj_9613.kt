package Boj.Silver

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class Boj_9613 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val sb = StringBuilder()

        var T = br.readLine().toInt()

        while (T --> 0) {
            val st = StringTokenizer(br.readLine())
            val n = st.nextToken().toInt()
            val arr = IntArray(101)
            for (i in 0 until n) {
                arr[i] = st.nextToken().toInt()
            }

            var sum :Long = 0;
            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    sum += GCD(arr[i], arr[j])
                }
            }
            sb.append(sum).append("\n")
        }

        bw.append(sb)
        bw.flush()
        bw.close()
    }

    fun GCD(n :Int, m :Int): Int {
        var a = n
        var b = m

        // a값이 더 크면 서로 바꿔준다
        if (a > b)
            a = b.also { b = a }

        while (a > 0) {
            val c = b % a
            b = a
            a = c
        }

        return b;
    }
}