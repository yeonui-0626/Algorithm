package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BJ_1181_단어정렬 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<N;i++){
            set.add(bf.readLine());
        }

        ArrayList<String> words = new ArrayList<>(set);
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length()-o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<words.size(); i++)
            sb.append(words.get(i)).append("\n");

        System.out.println(sb.toString());
    }
}
