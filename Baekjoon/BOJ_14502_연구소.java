package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
    static int N,M, max=0;
    static int[][] map;
    static int[][] tmpMap;
    static ArrayList<Point> ables;
    static Queue<Point> virus;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tmpMap = new int[N][M];

        ables = new ArrayList<>();
        virus = new LinkedList<>();

        for(int i = 0; i < N;i++){
            st = new StringTokenizer(bf.readLine()," ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==0 ) ables.add(new Point(i,j));    // 벽을 설치할 수 있는 위치 저장
                else if(map[i][j]==2) virus.offer(new Point(i,j)); // 바이러스 위치 저장
            }
        } // input

        select(0,0,new int[3]);
        System.out.println(max);
    }

    static void select(int cnt, int idx,int[] selected){
        if(cnt == 3) {

            init();          // tmpMap 초기화, virus 위치 다시 저장

            build(selected);    // 벽 설치

            spread();           // 바이러스 전파

            max = Math.max(max,safeCount() );
            return;
        }

        if(idx== ables.size()) return;

        selected[cnt] = idx;
        select(cnt+1, idx+1,selected);
        selected[cnt] = 0;
        select(cnt, idx+1, selected);
    }
    static void build(int[] selected){
        for(int i : selected){
            Point p = ables.get(i);
            tmpMap[p.r][p.c] =  1 ; // 벽 설치
        }
    }
    static void spread(){
        while(!virus.isEmpty()){
            Point cur = virus.poll();
            for(int d = 0; d < 4; d++){
                int mr =cur.r + dr[d];
                int mc =cur.c + dc[d];
                if(mr < 0 || mr>=N || mc<0 || mc>=M) continue;
                if(tmpMap[mr][mc] == 1) continue;
                if(tmpMap[mr][mc] == 0){
                    tmpMap[mr][mc] = 2;
                    virus.offer(new Point(mr,mc));
                }
            }
        }
    }
    static int safeCount(){
        int safe=0;
        for(int i = 0; i<N;i++){
            for(int j= 0 ;j<M;j++){
                if(tmpMap[i][j] == 0) safe++;
            }
        }
        return safe;
    }
    static void init(){
        for(int i = 0; i<N;i++){
            for(int j= 0 ;j<M;j++){
                tmpMap[i][j] = map[i][j];   // tmpMap
                if(map[i][j] == 2) virus.offer(new Point(i,j));
            }
        }
    }

}
