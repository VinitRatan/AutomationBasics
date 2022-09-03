package org.TopTal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountIOTDevices {
//devicenames = ['switch', 'tv', 'switch', 'tv', 'switch', 'tv']
    public static List<String> getDevices(List<String> input){
        List<String> output=new ArrayList();

        Map<String,Integer> m=new LinkedHashMap();
        for(int i=0;i< input.size();i++){
            if(m.containsKey(input.get(i))){
                m.put(input.get(i),m.get(input.get(i))+1);
                output.add(input.get(i)+m.get(input.get(i)));

            }

            else{

                m.put(input.get(i),0);
                output.add(input.get(i));
            }
        }

        return output;

    }


    public static void main(String[] args){
        List<String> input=new ArrayList();
        input.add("switch");
        input.add("tv");
        input.add("switch");
        input.add("tv");
        input.add("switch");
        input.add("tv");

        System.out.println("input: "+ input);

        System.out.println("output: "+ getDevices(input));

    }

}
