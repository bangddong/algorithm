package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_20291 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static TreeMap<String, Integer> map;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine().split("\\.")[1], map.getOrDefault(br.readLine().split("\\.")[1], 0) + 1);
        }
        for(String str : map.keySet()) {
            sb.append(str).append(" ").append(map.get(str)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
