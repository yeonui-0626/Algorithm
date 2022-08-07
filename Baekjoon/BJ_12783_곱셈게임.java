package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12783_곱셈게임 {

    static ArrayList<Integer> nums;
    static int[][] targets;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            nums = new ArrayList<>();
            while(st.hasMoreTokens()){
                nums.add(Integer.parseInt(st.nextToken()));
            }
            System.out.println(nums.toString());

            int q = Integer.parseInt(br.readLine());
            targets = new int[q][2];
            for(int i = 0; i < q; i++){
                targets[i][0] = Integer.parseInt(br.readLine());
            }

            for(int i = 0; i<nums.size();i++){
                boolean[] visited = new boolean[nums.size()];
                visited[i] = true;
                makeNum(0, nums.get(i)+"", visited, nums.size());
            }



        }

    }


/*

숫자 -> 조합의 수
만들어질 때마다 체크

 */
    static void makeNum(int idx,  String selected, boolean[] visited, int N){

        System.out.println(selected);
//        check(selected);

        if(idx == N) {

            return;
        }
        for(int i = 0 ; i<N; i++){
            if(visited[i]) continue;
            String selected_new = selected + nums.get(i);
            visited[i] = true;
            makeNum(idx+1, selected_new, visited,N);
            visited[i] = false;
        }
    }
    static void check(String num ){
        if(num.length()>1){
        }else{

        }
    }
}
