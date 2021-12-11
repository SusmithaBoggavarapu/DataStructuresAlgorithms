package arrays.assignment1;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-common-characters/
class CommonChars {
    public static List<String> commonChars(String[] words) {
        int[][] charCount = new int[26][words.length];
        List<String> commonChars = new ArrayList<>();

        for(int i=0; i < words.length;i++){
            String word = words[i];
            for (int j = 0; j < word.length() ; j++) {
                charCount[word.charAt(j)-'a'][i]++;
            }
        }

        for (int i = 0; i < charCount.length; i++) {
            int min = charCount[i][0];
            for (int j = 1; j < charCount[0].length; j++) {
                if(min > charCount[i][j]){
                    min = charCount[i][j];
                }
            }
            while (min > 0){
                char c = (char) ('a' + i);
                commonChars.add(String.valueOf(c));
                min--;
            }
        }
        
        return commonChars;
    }
    public static void main(String[] args){
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }
}