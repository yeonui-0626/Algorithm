package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1018_체스판다시칠하기 {
    static int N,M;
    static char[][] map;
    static char[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        temp = new char[N][M];

        for(int i = 0;i<N;i++){
            map[i] = bf.readLine().toCharArray();
            copy(temp,map);
        }
        int ans = 64;
        for(int i = 0; i <= N-8;i++){
            for(int j = 0 ; j<= M-8;j++){
                int result = find(i,j);
                ans = Math.min(ans , Math.min(result, 64-result));
                copy(map,temp);
            }
        }
        System.out.println(ans);

    }



    static int find(int si, int sj){
        int cnt = 0;

        for(int i = si ; i<si+8;i++){
            for(int j = sj;j<sj+8;j++){
                if(i==si && j==sj) continue;
                if(j == sj){
                    if(map[i-1][j] == map[i][j]){
                        map[i][j] = map[i][j] == 'B' ? 'W' : 'B';
                        cnt++;
                    }
                }else{
                    if(map[i][j-1] == map[i][j]){
                        map[i][j] = map[i][j] == 'B' ? 'W' : 'B';
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    static void copy(char[][] a, char[][] b){
        for(int i = 0; i <N; i++){
            for(int j = 0; j<M; j++){
                a[i][j] = b[i][j];
            }
        }
    }
}
