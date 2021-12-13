package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String str = "";
    static String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    // 1. 크로아티아 알파벳과 치환되는 문자 체크 (중복됨)
    // 2. 치환된 문자 카운트 후 제거
    // 3. 남은 문자 카운트
    public static void main(String[] args) throws IOException {
        str = br.readLine();
        convertAlphabet();
    }

    static void convertAlphabet() {
        for (String s : cro) {
            if (str.contains(s)) str = str.replace(s, "*");
        }
        System.out.println(str.length());
    }
}
