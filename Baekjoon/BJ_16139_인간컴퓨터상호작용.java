package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*

모든 알파벳이 나오는 횟수를 누적으로 저장해(메모이제이션) 시간을 줄임

누적 횟수를 구할 때,
먼저 이전 값을 저장하고 알파벳 위치를 +1 한다.
문자열을 기준으로 알파벳 26개를 계산핟.
apple
a를 먼저 봄.
a~z까지 누적
a 위치 +1


 */
public class BJ_16139_인간컴퓨터상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String str = bf.readLine();
        int q = Integer.parseInt(bf.readLine());

        int[][] nums = new int[26][str.length()+1];

        for(int i = 1; i<=str.length();i++){
                for (int j = 0; j < 26; j++)
                    nums[j][i] = nums[j][i - 1];
                int current = str.charAt(i-1) - 'a';
                nums[current][i]+=1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i< q; i++){
            st = new StringTokenizer(bf.readLine());

            char alphabet = st.nextToken().toCharArray()[0];
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(nums[alphabet-'a'][r+1]-nums[alphabet-'a'][l]).append('\n');

        }
        System.out.println(sb.toString());
    }
}
