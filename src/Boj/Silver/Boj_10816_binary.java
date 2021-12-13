package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816_binary {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() throws IOException{
        Arrays.sort(A, 1, N + 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int lower = lower(num);
            int upper = upper(num);
            sb.append(upper - lower).append(' ');
        }
        System.out.println(sb.toString());
    }

    static int lower(int num) {
        int lt = 1, rt = N, answer = N + 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (A[mid] >= num) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    static int upper(int num) {
        int lt = 1, rt = N, answer = N + 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (A[mid] > num) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
}
