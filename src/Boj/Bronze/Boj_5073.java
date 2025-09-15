package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5073 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int a, b, c;

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0) break;
			System.out.println(solution());
		}
	}

	static String solution() {
		int max = Math.max(a, Math.max(b, c));
		int sumOfOther = a + b + c - max;

		if (sumOfOther <= max) return "Invalid";
		if (a == b && b == c) return "Equilateral";
		else if (a == b || b == c || a == c) return "Isosceles";
		else return "Scalene";
	}
}
