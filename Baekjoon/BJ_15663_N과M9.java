package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
결국은 counts를 이용해서 풀었다.
counts에 갯수를 저장하고 입력된 숫자는 hashset으로 저장하여 중복을 없애준다.
기존의 visit 대신 count를 이용하여 방문을 확인하고
count가 1이상일 경우 계속 탐색 가능하도록 하면 된다.
 */
public class BJ_15663_N과M9 {

    static int M,N;
    static Integer[] arr; 									// 입력 받은 숫자 list
    static int[] nums;							// 수열 저장 배열
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> arrSet = new HashSet<>();
    static int[] counts = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];

        st =  new StringTokenizer(bf.readLine(), " ");
        for(int i = 0 ; i<N; i++) {
            int inp = Integer.parseInt(st.nextToken());
            arrSet.add(inp);
            counts[inp] +=1;
        }

        arr = arrSet.toArray(new Integer[0]);
        N = arr.length;
        Arrays.sort(arr);

        Permutation(0);
        System.out.println(sb);
    }
    static void Permutation(int cnt) {

        if (cnt == M) {
            StringBuilder tmp = new StringBuilder();
            for (Integer a : nums) {
                tmp.append(a).append(" ");
            }
            tmp.append("\n");
            sb.append(tmp);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(counts[arr[i]]==0) continue;
            nums[cnt] = arr[i];
            counts[arr[i]]--;
            Permutation(cnt + 1);
            counts[arr[i]]++;
        }
    }
}