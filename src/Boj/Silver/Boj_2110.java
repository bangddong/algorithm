package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr, 1, N + 1);
        int lt = 1, rt = 1000000000, answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1, last = arr[1];
            for (int i = 2; i <= N; i++) {
                if (arr[i] >= last + mid) {
                    cnt++;
                    last = arr[i];
                }
            }
            if (cnt >= C) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
