package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_15664_N과M10 {

    static int M, N;
    static Integer[] arr;                                    // 입력 받은 숫자 list
    static int[] nums;                            // 수열 저장 배열
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> arrSet = new HashSet<>();
    static int[] counts = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int inp = Integer.parseInt(st.nextToken());
            arrSet.add(inp);
            counts[inp] += 1;
        }

        arr = arrSet.toArray(new Integer[0]);
        N = arr.length;
        Arrays.sort(arr);

        Permutation(0,0);
        System.out.println(sb);
    }

    static void Permutation(int cnt, int idx) {

        if (cnt == M) {
            StringBuilder tmp = new StringBuilder();
            for (Integer a : nums) {
                tmp.append(a).append(" ");
            }
            tmp.append("\n");
            sb.append(tmp);
            return;
        }
        for (int i = idx; i < N; i++) {
            if (counts[arr[i]] == 0) continue;
            nums[cnt] = arr[i];
            counts[arr[i]]--;
            Permutation(cnt + 1,i);
            counts[arr[i]]++;
        }

    }
}
