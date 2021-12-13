package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] nArr, mArr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mArr = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(nArr, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            if (exist(mArr[i])) System.out.println(1);
            else System.out.println(0);
        }
    }

    static boolean exist(int num) {
        int lt = 1, rt = N;

        while(lt <= rt) {
            int mid = (lt  + rt) / 2;
            if (nArr[mid] == num) return true;
            if (nArr[mid] >= num) rt = mid - 1;
            else lt = mid + 1;
        }
        return false;
    }
}
