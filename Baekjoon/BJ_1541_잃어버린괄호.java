package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*

음수가 뒤의 수식에 괄호를 치게되면
최소값이 나온다 ... !
이런 방법이 ....................

 */
public class BJ_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        ArrayList<String> items = new ArrayList<>();
        int s = 0;
        for(int i = 0 ; i < input.length(); i++){
            char now = input.charAt(i);
            if(now == '+' || now == '-'){
                String numStr = input.substring(s,i);
                items.add(numStr);
                items.add(now+"");
                s=i+1;
                continue;
            }
        }
        items.add(input.substring(s));

        int result = Integer.parseInt(items.get(0));
        outer: for(int i = 1; i < items.size(); i++){
            if(items.get(i).equals("+")) continue;
            if(items.get(i).equals("-")) {
                for(int j = i+1; j < items.size(); j++){
                    if(items.get(j).equals("+")) continue;
                    if(items.get(j).equals("-")) continue;
                    result -= Integer.parseInt(items.get(j));

                }
                break outer;
            }
            result += Integer.parseInt(items.get(i));
        }
        System.out.println(result);
    }

}
