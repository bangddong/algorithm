package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2816 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		list = new ArrayList<>();

		n = Integer.parseInt(br.readLine());
		while (n --> 0) {
			String channel = br.readLine();
			list.add(channel);
		}
		System.out.println(solution());
	}

	static String solution() {
		StringBuilder sb = new StringBuilder();
		int kbs1Idx = list.indexOf("KBS1");
		int kbs2Idx = list.indexOf("KBS2");

		if (kbs1Idx > kbs2Idx) kbs2Idx += 1;

		sb.append("1".repeat(kbs1Idx));
		sb.append("4".repeat(kbs1Idx));

		sb.append("1".repeat(kbs2Idx));
		sb.append("4".repeat(kbs2Idx - 1));

		return sb.toString();
	}
}
