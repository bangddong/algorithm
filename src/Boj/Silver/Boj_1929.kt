package Boj.Silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Boj_1929 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val min = st.nextToken().toInt()
        val max = st.nextToken().toInt()
        val arr = Array(max + 1) { true }
        arr[0] = false
        arr[1] = false

        var i = 2
        while (i * i <= max) {
            if (!arr[i]) {
                i++
                continue
            }

            for (j in i * i .. max step i) arr[j] = false
            i++
        }

        val sb = StringBuilder()
        for (k in min .. max) {
            if (arr[k]) sb.append(k).append("\n")
        }
        println(sb)
    }
}