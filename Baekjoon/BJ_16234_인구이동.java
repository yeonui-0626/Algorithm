package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {

    static class Point{
        int x, y;
        public Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return this.x + ", " + this.y+"\n";
        }
    }
    static int N, L, R;
    static int map[][];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N]; // 인구 수 저장

        for(int i = 0; i < N;  i++ ){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j< N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// input


        int day = 0; // 구역 번호
        while(true){

            boolean[][] visit = new boolean[N][N];

            flag = false; // 인구 이동이 발생 했는지

            for(int i =0; i< N;i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) continue;
                    bfs(0, i, j, visit); // 연합
                }
            }
            if(!flag) break;
            day++;
        }
        System.out.println(day);
    }

//visit, cnt,
    static void bfs(int n, int sx, int sy, boolean[][] visit){ // n : 연합 구역 번호
        Queue<Point> q = new LinkedList<>();
        Queue<Point> combine = new LinkedList<>();

        q.offer(new Point(sx,sy)); //  시작 지점
        int total  = 0;  // 연합의 인구수
        int cnt = 0; // 연합을 이루고 있는 칸의 수


        while(!q.isEmpty()){

            Point current = q.poll();

            combine.add(current); // 연합에 추가
            visit[current.x][current.y] = true;
            total += map[current.x][current.y]; // 인구수 합침.
            cnt++ ; // 칸 수 증가

            // 인접 국가 탐색 -> 연합할 수 있는지
            for(int d = 0; d < 4 ; d++){
                int mx = current.x + dx[d];
                int my = current.y + dy[d];

                if(!avail(mx,my) ) continue;

                // 연합 할 수 있다먄 표시
                if(check(current, new Point(mx,my)) && !visit[mx][my]){
                    visit[mx][my] = true;
                    q.add(new Point(mx,my));
                }
            }
        }

        if(combine.size()>1){
//            System.out.println("인구 이동");
            flag = true; // 인구 이동 있음
//            System.out.println(combine.toString());

            // 인구수 업데이트
            int newNum = total/cnt;
            while(!combine.isEmpty()){
                Point p = combine.poll();
                map[p.x][p.y] = newNum;
            }
        }



    }
    static boolean check(Point p1, Point p2){
        int tmp = Math.abs(map[p1.x][p1.y] - map[p2.x][p2.y]); //인구수 차이

        if( L<= tmp  && tmp <= R ){
            return true;
        }
        return false;
    }
    static boolean avail(int x, int y){
        if( x < 0 || x >= N || y<0 || y>= N) return false;
        return true;
    }
}
