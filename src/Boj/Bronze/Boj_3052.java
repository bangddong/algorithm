package Boj.Bronze;

import java.util.HashSet;
import java.util.Scanner;

public class Boj_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : arr) {
            hs.add(x % 42);
        }
        System.out.println(hs.size());
    }
}
