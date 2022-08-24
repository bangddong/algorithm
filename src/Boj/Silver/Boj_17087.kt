package Boj.Silver

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

class Boj_17087 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val s = st.nextToken().toInt()

        val arr = br.readLine().split(' ').map { abs(s - it.toInt()) }
        var prev = arr[0]
        for (a in arr)
            prev = GCD(a, prev)

        bw.write("$prev")
        bw.flush()
        bw.close()

    }

    fun GCD(n :Int, m : Int): Int {
        var a = n
        var b = m

        if (a > b)
            a = b.also{b = a}

        while (a > 0) {
            val c = b % a
            b = a
            a = c
        }

        return b
    }

}