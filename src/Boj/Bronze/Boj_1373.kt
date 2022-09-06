package Boj.Bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Boj_1373 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var n = br.readLine();

        if (n.length % 3 == 1) n = "00$n"
        if (n.length % 3 == 2) n = "0$n"

        for (i in n.indices step 3) {
            bw.append((n[i].toString().toInt() * 4 + n[i + 1].toString().toInt() * 2 + n[i + 2].toString().toInt()).toString())
        }

        bw.flush()
        bw.close()

    }
}