package Baekjoon;

import java.util.Scanner;

public class BJ_2941_크로아티아알파벳 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();

        int idx = 0;
        int cnt=0;
        while(idx < str.length-1){
            String word= str[idx] +""+ str[idx+1];
            if(word.equals("c=")){
                cnt++; idx += 2;
            }else if(word.equals("c-")){
                cnt++; idx += 2;
            }else if(word.equals("dz")){
                if(idx+2 < str.length && str[idx+2] == '='){
                    cnt++; idx += 3;
                }else{
                    cnt++; idx++;
                }
            }else if(word.equals("d-")){
                cnt++; idx += 2;
            }else if(word.equals("lj")){
                cnt++; idx += 2;
            }else if(word.equals("nj")){
                cnt++; idx += 2;
            }else if(word.equals("s=")){
                cnt++; idx += 2;
            }else if(word.equals("z=")){
                cnt++; idx += 2;
            }else{
                cnt++; idx++;
            }
        }
        if(idx == str.length-1) cnt++;
        System.out.println(cnt);
    }
}
