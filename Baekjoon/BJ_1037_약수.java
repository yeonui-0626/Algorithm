package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1037_약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());
        ArrayList<Integer> nums = new ArrayList<>();

        st = new StringTokenizer(bf.readLine()," ");
        for(int t = 0 ; t<T;t++){
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        long min = nums.get(0);
        long max = nums.get(nums.size()-1);

        System.out.println(min*max);


    }
}
