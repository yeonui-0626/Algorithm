package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*

 */

public class SWEA_1249_보급로 {

    static int N;
    static int[][] map, time;

    static class Point implements Comparable<Point>{
        int x,y,w;

        public Point(int x, int y,int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for(int t =1;t<=T;t++){
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            time = new int[N][N];

            for(int i = 0 ; i < N; i++){
                String str = bf.readLine();
                for(int j = 0 ; j<N; j++){
                    map[i][j] = str.charAt(j)-'0';
                    time[i][j] = Integer.MAX_VALUE;
                }
            }
            go();
            System.out.println("#"+t+" "+time[N-1][N-1]);
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static void go(){
        Queue<Point> pq = new LinkedList<>();

        time[0][0] = map[0][0];
        pq.offer(new Point(0,0,time[0][0]));

        while(!pq.isEmpty()){
            Point cur = pq.poll();

            if(cur.x ==N-1 && cur.y==N-1) return;

            for(int d = 0 ; d<4;d++){
                int mx = cur.x + dx[d];
                int my = cur.y +dy[d];
                if(mx < 0 || mx>=N||my < 0 || my>=N) continue;

                if(time[mx][my] > cur.w+map[mx][my]){
                    time[mx][my] = cur.w+map[mx][my];
                    pq.offer(new Point(mx,my,time[mx][my]));
                }
            }
        }
    }
}
