package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*

골4 백트래킹 문제는 완전탐색 기초 + 디테일인 것 같다.
내가 생각한 로직이 맞아서 다행이다.
항상 디테일은 놓친다 ㅜ

이번 문제에서는 이동횟수가 10번 보다 많으면 -1을 출력하는 거라서
ans에 10을 저장하고 ans 가 10 그대이면 -1을 출력하는 것으로 짰는데,
이렇게 하면 10회 이동해서 동전을 떨어뜨린 경우도 -1이 출력된다...... 이 부분을 놓쳐서 계속 해맨것이 아쉽다.

내가 생각한 로직
1. 이동할 방향을 선택.
2. 이동했을 때, 떨어지는지 확인.
3. 몇 개의 동전이 떨어졌는지 확인.
   3-1. 하나만 떨어짐
   - ans를 최소값으로 업데이트 => continue(다른 방향 탐색)
   3-2. 둘 다 떨어짐
   - 더 이상 탐색하지 않음 => continue(다른 방향 탐색)
4. (둘 다 떨어지지 않았다면) 이동 했을 때 벽인지 확인
   - 벽이라면 이동하지 않고 원래 위치로
5. 이동 후, 또 탐색 (1번부터 다시 반복)

 */
public class BJ_16197_두동전 {

    static int N,M, ans;
    static char[][] map;
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st. nextToken());
        M = Integer.parseInt(st. nextToken());
        map = new char[N][M];
        ans = 11;
        int cx1=-1, cy1=-1, cx2=-1, cy2=-1;

        for(int i = 0; i<N;i++){
            map[i] = bf.readLine().toCharArray();
            for(int j = 0; j<M;j++){
                if(map[i][j]=='o'){
                    if(cx1 == -1 && cy1 == -1 ) {cx1 = i; cy1 = j;}
                    else{ cx2 = i; cy2 = j;}
                }// 두 동전의 위치 저장
            }
        }

        moveCoin(0,cx1, cy1,cx2, cy2);
        if(ans == 11) System.out.println(-1);
        else System.out.println(ans);

    }

    static void moveCoin(int cnt, int cx1, int cy1, int cx2, int cy2){ // cnt : 이동횟수
        if( cnt > ans ) return;

        //이동
        for(int i = 0;i < 4; i++){

            int mcx1 = cx1 + dir[i][0] ,mcy1 = cy1 + dir[i][1];
            int mcx2 = cx2 + dir[i][0] ,mcy2 = cy2 + dir[i][1];

            // 이동 후, 떨어지는지 체크
            boolean c1Drop=false, c2Drop=false;
            if (!isAvail(mcx1, mcy1)) c1Drop = true;
            if (!isAvail(mcx2, mcy2)) c2Drop = true;

            // 몇개의 동전이 떨어졌는지 확인
            if( c1Drop ^ c2Drop ){ // Drop 이 서로 다르면 하나만 떨어진 것
                ans = Math.min(ans, cnt+1);
                continue;
            }else if ( c1Drop & c2Drop ){ // 둘다 떨어짐
                continue;
            }else{
                // 안 떨어졌으면 이동할 수 있는지 확인
                if(map[mcx1][mcy1]=='#' & map[mcx2][mcy2]=='#') { // 둘 다 벽이라면 더이상 이동 x
                    continue;
                }
                //벽이라면 원래 자리로
                if(map[mcx1][mcy1]=='#'){
                    mcx1 =  cx1; mcy1 = cy1;
                }
                if(map[mcx2][mcy2]=='#'){
                    mcx2 =  cx2; mcy2 = cy2;
                }
                moveCoin(cnt+1,mcx1, mcy1, mcx2, mcy2);
            }
        }
    }
    static boolean isAvail(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
