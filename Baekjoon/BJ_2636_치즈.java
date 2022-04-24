package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {

    static int R,C;
    static int[][] cheese;
    static int total;

    static int[] dc = {0,1,0,-1};   // 하, 우, 상, 좌
    static int[] dr = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cheese = new int[R][C];
        total = 0;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<C;j++){
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if(cheese[i][j]==1) total++;
            }
        } // input


        int time = 0, lastCnt=0; // lastCnt : time 시간에 녹은 치즈의 갯수
        while(total>0){ // 치즈가 다 녹을 때까지 반복
            dfs(0,0,++time,new int[R][C]); // 탐색 - 녹일 치즈 표시
            lastCnt = cntCheese(time);          // 치즈 녹이고 다음 시간을 준비
        }

        System.out.println(time);
        System.out.println(lastCnt);

    }


    static void dfs(int r, int c, int time, int[][] visit){

        if(total==0) return; // 치즈가 다 녹았다면 탐색 종료

        if(cheese[r][c]==1){ // 치즈라면
            total--;         // 치즈 수 감소
            cheese[r][c] = time+1; // 녹일 치즈 표시(초기값이 1이므로 n시간에 녹을 치즈를 n+1로 표시한다)
            visit[r][c] = 1;        // 탐색하지 못하도록 방문 표시
            return;
        }

        visit[r][c] = 1;    // 방문표시

        for(int d = 0;d<4;d++){ // 사방탐색
            int mr = r + dr[d];
            int mc = c + dc[d];
            // 갈 수 없거나 방문 한 곳이라면 continue;
            if(!isAvail(mr,mc) || visit[mr][mc] != 0) continue;
            dfs(mr,mc,time,visit);
        }
    }

    static int cntCheese(int time){ // 현재 시간이 녹일 치즈 수 구하기
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(cheese[i][j] == time+1){ // 현재시간 +1 로 표시 해뒀으므로 time+1로 표시되어있다면 현재 시간에 녹는 치즈
                    cnt++;
                    cheese[i][j] = 0; // 치즈 녹이기
                }
            }
        }
        return cnt;
    }

    static boolean isAvail(int r, int c){
        if(r < 0 || r>=R || c<0||c >=C) return false;
        return true;
    }

}
