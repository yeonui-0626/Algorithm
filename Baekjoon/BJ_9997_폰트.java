package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

비트 연산을 활용하는 문제
처음에는 set 을 이용해 알파벳을 중복제거하여 저장하고
모든 알바펫을 포함하는지는 set의 길이 == 26로 확인했지만 시간초과가 났다.

이런 경우에서 비트연산을 활용하면 시간을 많이 줄일 수 있다.
단순 방문이 체크가 아니 알파벳을 확인하는데에도 비트연산자를 활용하는 방법을 배운 문제였다.

 */
public class BJ_9997_폰트 {
    static int N, ans, ansBit;
    static int[] alphaBit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        alphaBit = new int[N];
        ansBit = (1<<('z'-'a'+1))-1;

        for(int i = 0 ; i<N; i++){
            String input = br.readLine();
            int bit = 0;
            for(int j = 0 ; j < input.length(); j++){
                bit |= (1 << input.charAt(j)-'a');
            }
            alphaBit[i] = bit;
        }

        makeSentence(0, 0);
        System.out.println(ans);
    }

    static void makeSentence(int idx,   int visit){

        if(idx == N) {
            if(visit == ansBit){
                ans +=1;
            }
            return;
        }
        makeSentence(idx+1, visit | alphaBit[idx]);
        makeSentence(idx+1, visit);

    }
}
