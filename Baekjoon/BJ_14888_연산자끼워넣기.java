package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {

    static int N;
    static int[] nums;
    static int[] ops;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        ops = new int[4];
        ops = new int[4];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4;i++){
            ops[i] = Integer.parseInt(st.nextToken());
        }

        calc(1,nums[0]);
        System.out.println(max);
        System.out.println(min);


    }

    static void calc(int cnt, int result){
        //System.out.println(" = "+result);
        if( cnt == N ){
            max = Math.max(max, result);
            min = Math.min(min,result);
            return;
        }

        for(int i = 0 ; i < 4;i++){
            int resultTmp = result;
            if(ops[i] !=0){

                ops[i]--;
                if(i == 0){ // +
                    //System.out.print(" + ");
                    resultTmp += nums[cnt];
                }else if(i==1){ // -
                    //System.out.print(" - ");
                    resultTmp -= nums[cnt];
                }else if(i==2){ // *
                    //System.out.print(" * ");
                    resultTmp *= nums[cnt];
                }else{ // /
                    //System.out.print(" / ");
                    if(result < 0){
                        resultTmp *= -1;
                        resultTmp /= nums[cnt];
                        resultTmp *= -1;
                    }else{
                        resultTmp /= nums[cnt];
                    }
                }
                //System.out.print(nums[cnt]);
                calc(cnt+1, resultTmp);
                ops[i]++;
            }
        }

    }

}
