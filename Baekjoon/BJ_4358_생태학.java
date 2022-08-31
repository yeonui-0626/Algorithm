package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_4358_생태학 {



    public static void main(String[] args)  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int totalTree = 0;
        String name = "";
        try{
            while( (name = br.readLine()) != null && !name.isEmpty() ){
                totalTree++;
                if(map.keySet().contains(name)){
                    int currentCnt = map.get(name);
                    currentCnt++;
                    map.put(name,currentCnt);
                }
                else{
                    map.put(name,1);
                }
            }
            List<String> keyList = new ArrayList<>(map.keySet());

            keyList.sort((s1, s2) -> s1.compareTo(s2));
            for (String key : keyList) {
                double ratio = ((double)map.get(key) / (double) totalTree)*100;
                ratio = Math.round(ratio*10000)/10000.0;
                System.out.printf("%s %.4f\n",key,ratio);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
