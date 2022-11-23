package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1. 불 번짐 => 불 리스트로 관리, 매 초 리스트 돌면서 불 번지기
2. 상근이 이동
3. 탈출 조건 -> 상근이 위치 outOfIndex 인지
    3-1. 최소 이동이지 확인
 */
public class BJ_5427_불 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static int T,W,H;
    static ArrayList<Point> fires;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;
        for(int t = 0 ;t<T;t++){
            st = new StringTokenizer(bf.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            System.out.println(W+", "+H);
            map = new char[H][W];
            fires = new ArrayList<>();

            Point s=null;

            for(int i = 0; i < H; i++){
                st = new StringTokenizer(bf.readLine());
                char[] input = st.nextToken().toCharArray();
                for(int j = 0 ; j<W; j++){
                    if(input[j] == '*'){
                        fires.add(new Point(i,j));
                    }else if(input[j] =='@'){
                        s = new Point(i,j);
                    }
                    map[i][j] = input[j];
                }
            }// input
            System.out.println(fires.size());
            // 상근 위치 표시 X
            map[s.x][s.y] = '.';
            dfs(s,0 );
            if(ans != Integer.MAX_VALUE){
                System.out.println(ans);
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }

    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int ans=Integer.MAX_VALUE;
    
    static void dfs(Point s, int cnt, char[][] map ){ //  s : 현재 상근 위치 ,cnt : 상근의 이동 횟수
        /*
        * 매초 -> 불이동 -> 상근 이동(탈출 확인, 탈출이라면 이동 횟수 비교 저장)
        * */

        System.out.println("현재 위치 : "+s.x+", "+s.y);
        System.out.println("이동 횟수 : "+cnt);

        // 새 맵
        char[][] newMap = new char[H][W];
        moveFire(newMap, map);

        for(int d = 0; d < 4; d++){
            int mx = s.x + dx[d];
            int my = s.y + dy[d];

            if(mx<0 || mx >= H || my < 0 || my >= W){ // 탈출 성공
                System.out.println("탈출");
                ans = Math.min(ans,cnt); // 최소 이동 횟수 저장
                return;
            }
            if(map[mx][my]=='.'){ // 그냥 땅이면 이동
                dfs(new Point(mx,my),cnt+1,newMap);
            }

        }

    }

    static void moveFire(char[][] dest, char[][] src){
        copy(dest,src);
        ArrayList<Point> newFire = new ArrayList<>();
        for(int i = 0; i< fires.size();i++){
            Point fire = fires.get(i);
            System.out.println("불 : " + fire.x +", "+ fire.y);
            for(int d = 0 ;d < 4;d++){
                int mx = dx[d] + fire.x;
                int my = dy[d] + fire.y;
                if(mx<0 || mx >= H || my < 0 || my >= W) continue;
                if(map[mx][my]=='*' || map[mx][my]=='#')continue; // 이미 불
                dest[mx][my] = '*'; // 불 번짐
                newFire.add(new Point(mx, my));
            }
        }
        fires.addAll(newFire);
//        return map;
    }

    static void copy(char[][] dest, char[][] src){
        for(int i = 0;i<H;i++){
            for(int j = 0 ; j < W; j++){
                dest[i][j] = src[i][j];
            }
        }
    }
    static void print(){
        for(int i = 0 ; i < H; i++){
            for(int j = 0 ; j < W;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
