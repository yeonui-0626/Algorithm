package Baekjoon;


import java.io.*;
import java.util.*;

/*
1개일 경우
2개일 경우
...
n 개일 경우

 */
public class BJ_9375_패션왕신해빈 {
    static ArrayList<Integer> counts;
    static int ans;
    static Map<String, Integer> items;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());
        for(int t = 0;t<T;t++){
            int n = Integer.parseInt(bf.readLine());

            ans = 1;
            items = new HashMap<>();

            for(int i = 0; i<n;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine()," ");
                String name = st.nextToken();
                String kind = st.nextToken();

                if(items.containsKey(kind)){
                    items.put(kind,items.get(kind)+1);
                }else{
                    items.put(kind,1);
                }
            }
            counts = new ArrayList<>(items.values());

            // 1 개인 경우 ~ num 개를 선택하여 만들 수 있는 조합의 수 구하기
            for(int i = 0; i< counts.size();i++){
                ans *=(counts.get(i)+1);
            }
            bw.write(String.valueOf(ans-1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
//
//    static void dressup(int N, int num, int cnt, int index, boolean[] visit, int combi){
//        if(cnt == N){
//            ans += combi;
//            return;
//        }
//
//        for(int i = index; i < num;i++){
//            if(!visit[i]){
//                visit[i] = true;
//                dressup( N, num, cnt+1, i+1, visit, combi*counts.get(i));
//                visit[i] = false;
//            }
//        }
//    }
}
