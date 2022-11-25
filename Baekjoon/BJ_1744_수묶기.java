package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 정렬
* 1 은 무조건 더해주는게 이득 !
1. 양수확인
    - 1 만나면 탐색 종료
2. 음수 확인
    - 0 이상이면 탐색 종료
3. 남은 양수
    -> 그냥 더해주면 됨
   남은 음수
    1. 영이 있다면 곱해서 소거 되므로 visit 체크만
    2. 영이 없다면 더해주고 visit 체크
 */
public class BJ_1744_수묶기 {

    static int N, minusCnt, zeroCnt;
    static int[] input;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        visit = new boolean[N];

        for(int i = 0; i < N ;i++){
            input[i] = Integer.parseInt(bf.readLine());
            if(input[i] < 0) minusCnt++;
            else zeroCnt++;
        }

        Arrays.sort(input);

        int result = 0;
        for(int i = N - 1 ;i >0; i-=2){
            if(input[i] <=1 || input[i-1] <=1 ) break; // 1이면 무조건 더해줘야함
            result += input[i] * input[i-1];
            visit[i] = true;
            visit[i-1] = true;
        }

        for(int i = 0 ; i < N-1; i+=2){
            if(input[i] >= 0 || input[i+1] >= 0) break;
            result += (input[i] * input[i+1]);
            visit[i] = true;
            visit[i+1] = true;
        }
        if((minusCnt%2)==1 && zeroCnt==0){
            result += input[minusCnt-1];
            visit[minusCnt-1] = true;
        }else if((minusCnt%2)==1 && zeroCnt>0){
            visit[minusCnt-1] = true;
        }
        for(int i = 0 ;i < N; i++){
            if(!visit[i]){
                result += input[i];
            }
        }
        System.out.println(result);
    }
}