package SW;

/*

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로집합 {

    static int N,max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T;t++){
            N = Integer.parseInt(br.readLine());
            max = 0;
            boolean isSame = true;
            int mod = -1;
            for(int i = 0; i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // 원점에서의 거리
                int d = Math.abs(x)+Math.abs(y);
                if(i == 0){
                    if(d%2==0) mod = 0;
                    else mod = 1;
                }else{
                    if((d%2)!=mod) isSame = false; // 짝, 홀이면 같이 원점에 도착할 수 없음.
                }
                max = Math.max(d,max); // 점들 중, 이동거리 최대인 점을 찾음
            }

            int ans=-1;

            if(isSame){

                // 몇번 이동을 해야 거리가 충족 되는지 n*(n+1)/2 >= max
                if(max==0) ans=0;
                else{
                    int n = 1;
                    while(n * (n+1) < max) n++;
                    ans = n+1;
                    max = Math.abs(max - (ans*(ans+1))/2); // 이동하고 남는 횟수
                    // 짝수이면 => 원점에서 왔다갔다 -> 원점 도착 가능
                    if(max%2==1){  // 홀수이면 => 현재의 ans에 따라 달라짐
                        if(ans%2==0) ans+=1;
                        else ans+=2;
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}
