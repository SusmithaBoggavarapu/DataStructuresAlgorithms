package javapractise.collections;

import java.util.*;

public class ListMap {
    public static void main(String[] args){
        Map<String, List<String>> listMap = new HashMap<>();
        List<String> values1 =  new ArrayList<>();values1.add("1");
        if(Objects.isNull(values1))
         listMap.put("startTS", null );
        listMap.containsKey("startTS");
        List<String> values = listMap.get("startTS");
        //1. value is there with null -> returns listMap.get("startTS") = null
        //2. key it self is not there -> returns listMap.get("startTS") = null 
   //     values.add("4");
        System.out.println(values);
        System.out.println(listMap);
    }
}
