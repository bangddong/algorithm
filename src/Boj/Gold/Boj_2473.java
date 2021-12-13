package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2473 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    // 1. 배열 정렬
    // 2. 인자 하나 선택 후 결과값이 0에 제일 가까운 수를 return
    // 3. 해당 숫자로 min, v1, v2, v3 갱신
    static void solution() {
        Arrays.sort(A, 1, N + 1);
        long min  = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3 = 0;

        for (int i = 1; i <= N - 2; i++) { // lt는 세 개를 고를 수 있는 상황까지만 보자
            int num = -A[i], lt = i + 1, rt = N;
            while(lt < rt) {
                if (min > Math.abs(-(long)num + A[lt] + A[rt])) {
                    min = Math.abs(-(long)num + A[lt] + A[rt]);
                    v1 = -num;
                    v2 = A[lt];
                    v3 = A[rt];
                }
                if (A[lt] + A[rt] > num) rt--; // A[lt] + A[rt]가 A[i]에 가까워지게 가자!
                else lt++;
            }
        }
        sb.append(v1).append(' ').append(v2).append(' ').append(v3);
        System.out.println(sb);
    }
}
