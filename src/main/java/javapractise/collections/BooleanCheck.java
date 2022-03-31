package javapractise.collections;

import java.util.HashMap;
import java.util.Map;

public class BooleanCheck {

    public static void main(String[] args){
    Map<String,Object> attributes = new HashMap<>();
        attributes.put("bool",true);

        if(Boolean.TRUE.equals(attributes.get("bosol")) )
            System.out.println("null is true");
        else
            System.out.println("null is false");
    }

}
