package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4095_최대정사각형 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 테스트케이스 종료
            if (N == 0 && M == 0) break;

            map = new int[N][M];

            boolean flag = false; // 입력에 1이 없으면 false
            for(int i = 0 ; i<N;i++){
                st = new StringTokenizer(bf.readLine(), " ");
                for(int j = 0 ; j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1) flag = true;
                }
            }// input

            int MAX;
            if(flag) { // 입력에 1이 있을 경우
                MAX=1;
                for (int i = 1; i < N; i++) {
                    for (int j = 1; j < M; j++) {
                        if (map[i][j] == 1) {
                            map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                            MAX = Math.max(map[i][j],MAX);
                        }
                    }
                }
                System.out.println(MAX);
            }else{
                System.out.println(0);
            }
        }
    }
}
