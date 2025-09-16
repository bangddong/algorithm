package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_11723 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int m;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		m = Integer.parseInt(br.readLine());

		set = new HashSet<>();

		while (m --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String operation = st.nextToken();
			int num = 0;
			if (!"all".equals(operation) && !"empty".equals(operation)) {
				num = Integer.parseInt(st.nextToken());
			}

			switch (operation) {
				case "add":
					add(num);
					break;
				case "remove":
					remove(num);
					break;
				case "check":
					check(num);
					break;
				case "toggle":
					toggle(num);
					break;
				case "all":
					all();
					break;
				case "empty":
					empty();
					break;
			}
		}
		System.out.println(sb.toString());
	}

	// list에 num을 추가한다.
	static void add(int num) {
		set.add(num);
	}

	// list에 num을 제거한다.
	static void remove(int num) {
		set.remove(num);
	}

	// list에 num이 있으면 1을 출력한다.
	static void check(int num) {
		if (set.contains(num)) {
			sb.append(1).append("\n");
			return;
		}
		sb.append(0).append("\n");
	}

	// list에 num이 있으면 제거하고, 없으면 추가한다.
	static void toggle(int num) {
		if (set.contains(num)) {
			remove(num);
			return;
		}
		set.add(num);
	}

	// list를 1~20으로 채운다.
	static void all() {
		set.clear();
		for (int i = 1; i < 21; i++) {
			set.add(i);
		}
	}

	// empty s를 공집합으로 바꾼다.
	static void empty() {
		set.clear();
	}
}
