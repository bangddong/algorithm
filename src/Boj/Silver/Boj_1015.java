package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] P;
    static Nums[] B;

    public static class Nums implements Comparable<Nums> {
        public int num, idx;

        @Override
        public int compareTo(Nums o) {
            if (num != o.num) return this.num - o.num;
            else return this.idx - o.idx;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = new int[N];
        B = new Nums[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Nums();
            B[i].num = Integer.parseInt(st.nextToken());
            B[i].idx = i;
        }
        sort();
    }

    static void sort() {
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }
        for (int x : P) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
}
