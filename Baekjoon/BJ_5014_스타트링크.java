package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*

총 F 층.
스타트 링크 -> G 층
강호 S 층
엘베타고 G 층으로 이동

2이랑 -1 조합으로 S -> G 로
최소 개수
1층에서 F층까지

DFS 와 BFS의 차이가 뭔데!!!!!!!!!!!!!!!


 */
public class BJ_5014_스타트링크 {
    static class Node implements Comparable<Node>{
        int floor, cnt;
        public Node(int f, int cnt){
            this.floor = f;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
    static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

//        dfs(0,S,S);
        if(S==G){
            System.out.println(0);
            return;
        }
        bfs();
        if(ans == Integer.MAX_VALUE) System.out.println("use the stairs");
        else System.out.println(ans);

     }
     static int ans = Integer.MAX_VALUE;


    static  void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[F+1];
        q.add(new Node(S,0));

        while(!q.isEmpty()){
            Node now = q.poll();
            visit[now.floor] = true;

            if( now.floor == G ){ // 도착
                ans = Math.min(ans, now.cnt);
                break;
            }


            if(now.floor + U <= F && !visit[now.floor + U]) {
                visit[now.floor+U] = true;
                q.add(new Node(now.floor + U, now.cnt+1));
            }

            if(now.floor - D > 0 && !visit[now.floor - D]) {
                visit[now.floor-D] = true;
                q.add(new Node(now.floor - D, now.cnt+1));
            }
        }

    }
}
