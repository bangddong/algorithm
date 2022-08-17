package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj_10824 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        String str1 = st.nextToken() + st.nextToken();
        String str2 = st.nextToken() + st.nextToken();

        BigInteger int1 = new BigInteger(str1);
        BigInteger int2 = new BigInteger(str2);

        System.out.println(int1.add(int2));
    }
}
