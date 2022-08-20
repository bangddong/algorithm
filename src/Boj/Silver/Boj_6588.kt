package Boj.Silver

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Boj_6588 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val sb = StringBuilder()

        val prime = BooleanArray(1000001)

        for (i in 2..1000000) if (!prime[i]) for (j in i * 2..1000000 step(i)) prime[j] = true

        while (true) {
            val n = br.readLine().toInt()
            var exists = false
            if (n == 0) break
            for (i in 3..n) if (!prime[i] && !prime[n - i]) {
                sb.appendLine("$n = $i + ${n - i}")
                exists = true
                break
            }

            if (!exists) sb.appendLine("Goldbach's conjecture is wrong.")
        }

        bw.append(sb)
        bw.flush()
        bw.close()
    }
}