package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_10431 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int p, t, steps;
	static ArrayList<Integer> students;

	public static void main(String[] args) throws IOException {
		p = Integer.parseInt(br.readLine());
		while (p --> 0) {
			steps = 0;
			students = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 20; i++) {
				int studentHeight = Integer.parseInt(st.nextToken());
				solution(studentHeight);
			}
			sb.append(t).append(" ").append(steps).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void solution(int studentHeight) {
		int position = students.size();

		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) > studentHeight) {
				position = i;
				break;
			}
		}

		steps += students.size() - position;
		students.add(position, studentHeight);
	}

}
