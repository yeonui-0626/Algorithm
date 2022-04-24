package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
bj 4485 녹색 옷 입은 애가 젤다지 ?
 */
public class BJ_4485_젤다 {

        static int N ;
        static int[][] map;
        static int[][] distances;

        static class Vertex implements Comparable<Vertex>{
                int i, j, cost;

                public Vertex(int i, int j, int cost) {
                        this.i = i;
                        this.j = j;
                        this.cost = cost;
                }

                @Override
                public int compareTo(Vertex o) {
                        return this.cost - o.cost;
                }
        }

        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = null;
                StringBuffer sb = new StringBuffer();

                int t = 0;
                while ((N = Integer.parseInt(br.readLine())) != 0) {

                        map = new int[N+1][N+1];
                        distances = new int[N+1][N+1];


                        for (int i = 1; i <= N; i++) {
                                st = new StringTokenizer(br.readLine(), " ");
                                for(int j = 1; j <= N;j++){
                                        map[i][j] = Integer.parseInt(st.nextToken());
                                        distances[i][j] = Integer.MAX_VALUE;
                                }
                        } // input


                        Dijkstra();

                        sb.append("Problem ").append(++t).append(": ").append(distances[N][N]).append("\n");
                }
                System.out.println(sb.toString());
                br.close();
        }

        static int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};

        static void Dijkstra(){
                PriorityQueue<Vertex>  edges = new PriorityQueue<Vertex>();

                distances[1][1] = map[1][1];
                edges.offer(new Vertex(1, 1, distances[1][1]));

                while(!edges.isEmpty()){
                        Vertex current = edges.poll();

                        if(current.i == N && current.j == N) return;

                        int mi=0, mj=0;
                        for(int d = 0 ; d < 4; d++){
                                mi = current.i + dir[d][0];
                                mj = current.j + dir[d][1];

                                if(isAvailable(mi, mj)){
                                        if(distances[mi][mj] > distances[current.i][current.j] + map[mi][mj]){
                                                distances[mi][mj] = distances[current.i][current.j] + map[mi][mj];
                                                edges.offer(new Vertex(mi, mj, distances[mi][mj]));
                                        }

                                }
                        }
                }

        }
        static boolean isAvailable(int i, int j ){
                if(i<1 || i > N || j < 1 || j > N){
                        return false;
                }else{
                        return true;
                }
        }
}
