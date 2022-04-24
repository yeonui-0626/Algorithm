package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

1. 시작 위치 현재 queue에 저장 (1 시간 경과)
2. 현재 위치에서 갈 수 있는 방향 확인 후, 갈 수 있는 방향에 있는 터널의 타입 확인
    - 갈 수 있는 터널타입 이고 아직 방문하지 않았다면 저장
    - 큐에 넣을 때 갈 수 있는 터널의 수 cont
3. 현재 queue 가 비었다면 다음 큐 탐색.(2시간 경과)
4. 위의 과정 반복
5. 현재 시간이 소요시간(L)과 같다면 종료

* 갈 수 있는지 확인
   - 좌로 간다면 갈 방향의 터널은 우를 포함
   - 하로 간가면 갈 방향을 터널은 상을 포함
     (반대로 마찬가지)

// 방향에 따라 갈 수 있는 다음 파이프 타입
상 방향 - 1, 2, 5, 6
하 방향 - 1, 2, 4, 7
좌 방향 - 1, 3, 4, 5
우 방향 - 1, 3, 6, 7

// 현재 파이프 타입에 따라 갈 수 있는 방향
1 : 상하좌우
2 : 상 하
3 : 좌 우
4 : 상 우
5 : 하 우
6 : 하 좌
7 : 상 좌



 */
public class SWEA_1953_탈주범검거 {

    static int N,M,R,C,L;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0}; // 상하좌우
    static int[] dc = {0,0,-1,1};
    static int cnt=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            // init
            map = new int[N][M];
            visit = new boolean[N][M];
            cnt = 0;

            for(int i = 0; i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j =0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // input

            Queue<int[]> queue = new LinkedList<int[]>();
            queue.add(new int[]{R,C,map[R][C]});
            visit[R][C] = true;
            cnt++;

            BFS(queue,1);

            sb.append("#").append(t).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void BFS(Queue<int[]> queue, int level){
        if(level == L){
            return;
        }

        Queue<int[]> nQueue = new LinkedList<>();

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int t = current[2]; //터널의 타입

            // ableDir : 현재 터널 타입에서 갈 수 있는 방향 return
            for(int d : ableDir(t)){ // 상하좌우 순
                int mr = r + dr[d];
                int mc = c + dc[d];
                if(mr <0||mr >=N||mc < 0 || mc>=M) continue; // map 범위 check
                int mt = map[mr][mc];
                int[] types = ableType(d); // ableType : 현재 방향에서 갈 수 있는 터널 타입 return
                if((types[0] == mt ||types[1] == mt || types[2] == mt || types[3] == mt)
                    &&  !visit[mr][mc]){
                    nQueue.offer(new int[]{mr,mc,mt});
                    visit[mr][mc] = true;
                    cnt++;
                }
            }

        }
        // 다음 터널들 탐색
        BFS(nQueue,level+1);
    }

    static int[] ableType(int d){ // 방향에 따라 갈 수 있는 다음 파이프 타입 return
        switch (d){
            case 0:
                return new int[]{1, 2, 5, 6};
            case 1:
                return new int[]{1, 2, 4, 7};
            case 2:
                return new int[]{1, 3, 4, 5};
            default:
                return new int[]{1, 3, 6, 7};
        }
    }
    static int[] ableDir(int t){ // 현재 파이프 타입에 따라 갈 수 있는 방향 return
        switch (t){
            case 1:
                return new int[]{0,1,2,3};
            case 2:
                return new int[]{0,1};
            case 3:
                return new int[]{2,3};
            case 4:
                return new int[]{0,3};
            case 5:
                return new int[]{1,3};
            case 6:
                return new int[]{1,2};
            default:
                return new int[]{0,2};
        }
    }

}
