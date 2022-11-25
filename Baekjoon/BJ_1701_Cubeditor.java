package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
못 풂
 */
public class BJ_1701_Cubeditor {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String text = bf.readLine();

        int N = text.length();
        int[] pi = new int[N];
        int j = 0;
        for(int i = 1 ; i<N; i++){
            while(j > 0 && text.charAt(i) != text.charAt(j)){
                j = pi[j-1]; // 다르다면 이전까지의 공통된 부분의 마지막으로 이동
            }
            if(text.charAt(i) == text.charAt(j)){
                pi[i] = ++j; // 같으면 이전까지의 공통된 부분의 마지막 인덱스 + 1
            }
        }
        int ans=0;
        for(int i : pi)
            ans = Math.max(ans,i);
        System.out.println(ans);
    }
}
