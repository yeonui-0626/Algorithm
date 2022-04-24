package Baekjoon;

import java.util.Scanner;

public class BJ_1316_그룹단어체커 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int ans=0;
        for(int t = 0; t < T;t++){
            boolean flag = true;
            int[] check = new int[26];

            char[] word = sc.next().toCharArray();

            for(int i = 0; i<word.length;i++){
                int idx = (int)word[i]-'a'; // 알파벳의 인덱스
                if(check[idx] != 0 && check[idx] + 1 != i){ // 이전에 나온 문자이고 연속된 문자가 아니라면 -> 그룹단어에 속하지 않음
                    flag = false;
                    break;
                }else{
                    check[idx] = i+1;
                }
            }
            if(flag) ans++;
        }
        System.out.println(ans);


    }
}
