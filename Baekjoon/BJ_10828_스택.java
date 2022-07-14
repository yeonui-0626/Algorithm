package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < N; i++){
            String cmd = br.readLine();
           if(cmd.equals("top")){
               if(stack.empty()) System.out.println(-1);
               else System.out.println(stack.peek());
            }else if(cmd.equals("size")){
               System.out.println(stack.size());
            }else if(cmd.equals("pop")){
               if(stack.empty()) System.out.println(-1);
               else System.out.println(stack.pop());
            }else if(cmd.equals("empty")){
               if(stack.empty()) System.out.println(1);
               else System.out.println(0);
            }else if(cmd.substring(0,4).equals("push")) {
               stack.push(Integer.parseInt(cmd.substring(5)));
           }
        }
    }
}
