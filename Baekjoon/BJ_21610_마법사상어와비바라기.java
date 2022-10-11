package Baekjoon;
/*

(N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름
1. 비구름 이동
2. 물의 양 1 증가
3. 물복사버그
4. 비구름 안생긴 칸 중, 2이상인 칸에 물의 양 2 감소
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_21610_마법사상어와비바라기 {

    static int N, M;
    static int[][] map;
    // 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dx = {0, 0,-1,-1,-1,0,1,1,1};
    static int[] dy = {0, -1,-1,0,1,1,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i = 1 ; i <= N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1; j <= N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] start = {{N, 1}, {N, 2}, {N - 1, 1}, {N - 1, 2}};
        ArrayList<int[]> m_cloud = new ArrayList<>();
        for(int s = 0; s < 4; s++ ){
            m_cloud.add(start[s]);
        }
        for(int i = 0 ; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 이동 방향
            int n = Integer.parseInt(st.nextToken()); // 이동 횟수

            boolean[][] visit = new boolean[N + 1][N + 1];
            ArrayList<int[]> mm_cloud = new ArrayList<>();

            for (int s = 0; s < m_cloud.size(); s++) {
                int sx = m_cloud.get(s)[0];
                int sy = m_cloud.get(s)[1];
                int[] moveTo = move(sx, sy, d, n);


                mm_cloud.add(new int[]{moveTo[0],moveTo[1]});

                // 비구름 지역 비내리기
                map[moveTo[0]][moveTo[1]] += 1;
                visit[moveTo[0]][moveTo[1]] = true;
            }

            for (int s = 0; s < mm_cloud.size(); s++) {
                int sx = mm_cloud.get(s)[0];
                int sy = mm_cloud.get(s)[1];
                //물복사 버그
                int[][] bug = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
                int cnt = 0;
                for (int b = 0; b < 4; b++) {
                    int mx = sx + bug[b][0];
                    int my = sy + bug[b][1];

                    if (mx <= 0 || mx > N || my <= 0 || my > N) continue;
                    if (map[mx][my] > 0) cnt++;
                }
                map[sx][sy] += cnt;
            }

            m_cloud = new ArrayList<>();
            // 구름 물양 -2
            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (!visit[x][y] && map[x][y] >= 2) {
                        map[x][y] -= 2;
                        m_cloud.add(new int[]{x,y});
                    }
                }
            }
        }
        int ans = 0;
        for(int x = 1; x<=N; x++){
            for(int y = 1; y<=N; y++){
                ans+=map[x][y];
            }
        }
        System.out.println(ans);
    }
    /*
    * 인덱스를 1으로 시작했기 때문에 나누었을 때 0으로 나오는 경우를 잘 처리해주어야한다.
    * 배열을 돌리기 위해 % 연산을 사용하고 + N 까지 하면 음수 인덱스가 나오는 경우는 처리된다.
    * 하지만 % 연산을 사용하기 때문에 N인덱스를 가져야할 부분에서 0인덱스로 바뀌는 순간을 조심해야한다.
    * */
    static int[] move(int sx, int sy, int d, int n){
        int mx = sx + dx[d]*n ,my = sy + dy[d]*n;
        mx = (mx%N + N)%N;
        my = (my%N + N)%N;
        mx = mx == 0 ? N : mx;
        my = my == 0 ? N : my;
        return new int[]{mx,my};
    }
}
