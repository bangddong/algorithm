package Boj.Bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Boj_1212 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val sb = StringBuilder()

        val line = br.readLine()
        val arr = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")

        for(i in line.indices) {
            val cur: Int = line[i] - '0'
            if(i == 0 && cur < 4) {
                sb.append(arr[cur].toInt())
            }else {
                sb.append(arr[cur])
            }
        }
        print(sb)
    }
}