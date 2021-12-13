package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10825 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Student implements Comparable<Student> {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Student o) {
            // 국 같다면 국어 내림차순
            if (this.korean != o.korean) return o.korean - this.korean;
                // 국 같고 영 다르면 영어 오름차순
            else if(this.english != o.english) return this.english - o.english;
                // 국,영 같고 수 다르면 수학 내림차순
            else if(this.math != o.math) return o.math - this.math;
                // 다 같을시 이름 오름차순
            else return this.name.compareTo(o.name);
        }
    }

    static int N;
    static Student[] students;

    // 1. 국어 내림차 순
    // 2. 영어 오름차 순
    // 3. 수학 내림차 순
    // 4. 이름 사전 순(대소문자 구분)
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        students = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student();
            students[i].name = st.nextToken();
            students[i].korean = Integer.parseInt(st.nextToken());
            students[i].english = Integer.parseInt(st.nextToken());
            students[i].math = Integer.parseInt(st.nextToken());
        }
        sort();
    }

    static void sort() {
        Arrays.sort(students);
        for(Student s : students) {
            sb.append(s.name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
