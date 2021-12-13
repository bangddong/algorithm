package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, max, min;
    static int[] nums, operators, order;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1]; // 수열
        operators = new int[5]; // 연산자 갯수
        order = new int[N + 1]; //
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= 4; i++) operators[i] = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        calc(1, nums[1]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }
    // 완성된 식에 따라 정답 갱신
    static int calculator(int num1, int operator, int num2) {
        if (operator == 1) // +
            return num1 + num2;
        else if (operator == 2) // -
            return num1 - num2;
        else if (operator == 3) // *
            return num1 * num2;
        else
            return num1 / num2;
    }
    // order에 연산자 저장
    static void calc(int L, int value) {
        if (L == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // 어떤 연산자를 선택할것인가 ?
            for (int i = 1; i <= 4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    order[L] = i;
                    calc(L + 1, calculator(value, i, nums[L + 1]));
                    order[L] = 0;
                    operators[i]++;
                }
            }
        }
    }
}
