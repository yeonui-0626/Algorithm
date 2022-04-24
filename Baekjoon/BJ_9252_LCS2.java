package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = bf.readLine().toCharArray();
        char[] str2 = bf.readLine().toCharArray();

        int N = str1.length; // row 위치
        int M = str2.length; // col 위치

        int[][] arr = new int[N+1][M+1];

        // LCS 를 구하는 DP 식
        // dp[i][j] = str1[i-1] == str2[j-1] ? dp[i-1][j-1] + 1 : max(dp[i-1][j],dp[i][j-1])
        for(int i = 1 ; i<= N;i++){
            for (int j = 1; j <= M; j++) {
                if(str1[i-1] == str2[j-1]) arr[i][j] = arr[i-1][j-1]+1;
                else arr[i][j] =  Math.max(arr[i-1][j],arr[i][j-1]);
            }
        }

        int cnt=arr[N][M];
        if(cnt==0){
            System.out.println(0);
            return;
        }else{
            System.out.println(cnt);
        }

        // LCS 역추적 과정
        int r=N,c=M,j=M; // 탐색 시작 인덱스를 j에 저장한다.
        char[] ans = new char[cnt];
        while(true) {
            if(cnt==0 || r==0 || c==0)break;
            if(arr[r][c] != arr[r-1][c-1] && arr[r][c] != arr[r][c-1] && arr[r][c] !=  arr[r-1][c]){ // 대각선에서 1이 되는 부분
                ans[--cnt] = str1[r-1];
                r=r-1;
                c=j=c-1; // 그 다음은 행,열 모두 작은 부분에서 탐색
                continue;
            }
            if(arr[r][c] != arr[r][c-1]) { // 열에 같은 숫자가 아니라면 행-1하고 다시 초기 열(j)부터
                r--;
                c=j;
            }
            else{
                c--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i1 = 0 ; i1<arr[N][M];i1++){
            sb.append(ans[i1]);
        }
        System.out.println(sb.toString());
    }

}
