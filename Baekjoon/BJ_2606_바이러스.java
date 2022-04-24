package Baekjoon;
/*

BFS 리마인드

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {

    static int N,M;
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean visit[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        adjList = new ArrayList<>();
        visit = new boolean[N+1];
        ans = 0;

        for(int i =0;i<=N;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        bfs(1);
        System.out.println(ans-1);

    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans++;
            for(int i = 0; i <adjList.get(cur).size();i++){
                if(!visit[adjList.get(cur).get(i)]){
                    visit[adjList.get(cur).get(i)] = true;
                    queue.add(adjList.get(cur).get(i));
                }
            }
        }

    }
}
