package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1786_찾기 {

    static int[] makeTable(String pattern){
        int patternSize = pattern.length();
        int[] table = new int[patternSize];

        int j = 0;
        for(int i = 1; i<patternSize; i++){
            while( j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = table[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                table[i] = ++j;
            }
        }
        return table;
    }

    static List<Integer> KMP(String text, String pattern){

        List<Integer> indexs = new ArrayList<>();

        int textSize = text.length();
        int patternSize = pattern.length();
        int[] table = makeTable(pattern);
        int j = 0;
        for(int i = 0 ; i < textSize; i++){
            while(j>0 && pattern.charAt(j) != text.charAt(i)){
                j = table[j-1];
                // j 이전 까지 동일, 이전까지의 값 중 일치하는 문자열 이후부터 탐색
            }
            if(text.charAt(i) == pattern.charAt(j)){
                if(j == patternSize - 1 ){
                    indexs.add(i-patternSize + 2);
                    j = table[j];
                }else{
                    j++;
                }
            }
        }
        return indexs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String text = bf.readLine();
        String pattern = bf.readLine();
        List<Integer> ans = KMP(text,pattern);

        StringBuffer sb = new StringBuffer();
        sb.append(ans.size()).append('\n');
        for(int i = 0 ; i < ans.size();i++){
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

}
