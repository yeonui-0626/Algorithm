package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

BJ_1149 RGB거리
DP 문제

풀이)
어떤 걸 선택 하느냐?의 문제

3개 중 한개를 골라야한다.
고를 때는 어떤게 최소 비용의 선택인지 알 수 없다.
(현재 선택할 수 있는 값 중 최소를 선택했다고 하더라도 누적합이 최소가 아닐 수도 있다.)
그래서 3가지의 경우를 모두 고려해야하고 이전의 선택을 고려해야한다.

1. 첫번째 색을 고르는 경우 -> dp[i][0]
2. 두번째 색을 고르는 경우 -> dp[i][1]
3. 세번째 색을 고르는 경우 -> dp[i][2]

현재 색을 선택할 때,
1. 현재 색을 제외한 나머지 색을 이전에 선택한 경우 중, 누적합이 최소인 것을 선택한다.
   => Math.min(dp[i-1][1] ,dp[i-1][2]) // 가능할 이전 선택들의 누적합을 비교
2. 최소 누적합을 선택하고 현재 비용을 더한다.
   - 이 값이 곧 i번째 집에 0을 선택했을 경우의 최소 누적합이다.
   => dp[i][0] = Math.min(dp[i-1][1] ,dp[i-1][2]) + arr[i][0]

- 예시)
 3번째 집을 0번째 색으로 칠하는 경우를 생각해보자.
 i = 3, 선택할 색 : 0
 dp[2][color] 에는 두번째 집에서 color(0<=color<=2)번째 색을 골랐을 경우의 최소 누적합이 저장되어있을 것이다.

 현재 집은 0번째를 선택해야하므로 이전에 0의 선택한 값을 고려할 필요가 없다.
 그래서 이전에 1번과 2번을 선택한 경우 중 최소값에 현재 집을 칠하는 비용을 합하여 저장한다.
 dp[3][0] = Math.min(dp[2][1] ,dp[2][2]) + arr[3][0];

 */
public class BJ_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(bf.readLine());

        int[][] arr=new int[N+1][3];
        int[][] dp = new int[N+1][3];
        int ans = 0;
        for(int i = 1 ; i<= N; i++){
            st = new StringTokenizer(bf.readLine()," ");
            for(int j = 0 ; j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input

        for(int i= 1; i <= N; i++){
            //1번색 선택
            dp[i][0] = Math.min(dp[i-1][1] ,dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0] ,dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0] ,dp[i-1][1]) + arr[i][2];
        }
        ans = Math.min(Math.min(dp[N][0],dp[N][1]), dp[N][2]);

        System.out.println(ans);

    }
}
