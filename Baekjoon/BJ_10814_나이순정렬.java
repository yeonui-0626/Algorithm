package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10814_나이순정렬 {

    static class Member implements Comparable<Member> {

        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age-o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(bf.readLine());
        ArrayList<Member> members = new ArrayList<>();
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(bf.readLine()," ");
            members.add(new Member(Integer.parseInt(st.nextToken()),st.nextToken()));
        }

        Collections.sort(members);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <N;i++)
            sb.append(members.get(i).toString()).append('\n');

        System.out.println(sb.toString());

    }
}
