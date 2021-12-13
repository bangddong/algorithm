package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Word[] words;

    public static class Word implements Comparable<Word> {
        String word;

        @Override
        public int compareTo(Word o) {
            if (this.word.length() == o.word.length()) return this.word.compareTo(o.word);
            else return this.word.length() - o.word.length();
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new Word[N];
        for (int i = 0; i < N; i++) {
            words[i] = new Word();
            words[i].word = br.readLine();
        }
        sort();
    }

    static void sort() {
        Arrays.sort(words);
        sb.append(words[0].word).append("\n");
        for (int i = 1; i < N; i++) {
            if (!words[i].word.equals(words[i - 1].word)) sb.append(words[i].word).append("\n");
        }
        System.out.println(sb.toString());
    }
}
