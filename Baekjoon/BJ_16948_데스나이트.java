package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*

DFS와 BFS의 차이에 대해 알 수 있었던 문제
DFS 깊이 우선으로 풀면 시간초과가 난다.
생각해보면 이동할때, 도착지가 안 나올지도 모르는데
계속 그 방향을 탐색하는 거는 비효율적인 것 같다.

DFS에 적합한 문제, BFS에 적합한 문제를 캐치해야할 것 같다
주변을 먼저 볼 것 인지, 깊이 까지 들어가서 볼 것 인지

 */
public class BJ_16948_데스나이트 {

    static int N, min;
    static int r1,c1,r2,c2;
    static boolean[][] visit;

    static int[] dr = {-2,0,2,2,0,-2};
    static int[] dc = {-1,-2,-1,1,2,1};

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        r1  = Integer.parseInt(st.nextToken());
        c1  = Integer.parseInt(st.nextToken());
        r2  = Integer.parseInt(st.nextToken());
        c2  = Integer.parseInt(st.nextToken());

        if(Math.abs(r2-r1)%2!=0){
            System.out.println(-1);
            return;
        }

        start = new Point(r1,c1);
        end = new Point(r2,c2);

        min = Integer.MAX_VALUE;
        visit = new boolean[N][N];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        BFS(queue,0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }


    static void BFS(Queue<Point> queue, int cnt){
        Queue<Point> next = new LinkedList<>();

        while(!queue.isEmpty()){

            Point cur = queue.poll();
            if(cur.x == end.x && cur.y == end.y) {
                min = Math.min(min,cnt);
                return;
            }

            if(visit[cur.x][cur.y]) continue;

            visit[cur.x][cur.y] = true;

            for(int d = 0 ;d<6;d++){
                int mr = cur.x + dr[d];
                int mc = cur.y + dc[d];
                if(mr < 0 || mr>=N || mc<0||mc>=N || visit[mr][mc]) continue;
                next.offer(new Point(mr,mc));
            }
        }

        if(next.isEmpty()) return;
        else BFS(next,cnt+1);
    }
}
