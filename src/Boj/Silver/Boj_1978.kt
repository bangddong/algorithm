import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    var tot = 0
    while (n --> 0) {
        if (isPrime(st.nextToken().toInt()))
            tot++

    }

    println(tot)
}

fun isPrime(num: Int): Boolean {
    if (num == 1) return false

    var i = 2
    while (i * i <= num) {
        if (num % i == 0) return false
        i++
    }

    return true
}