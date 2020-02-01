package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		System.out.println(res);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
        //Key = sorted string  Value = list of anagrams
        Map<String, List<String>> sortedStringToAnagram = new HashMap<String, List<String>> ();
        for(int i=0;i<strs.length;i++){
            char[] sortedCharArray = strs[i].toCharArray();
            Arrays.sort(sortedCharArray);
            String sortedString = new String(sortedCharArray);
            if(!sortedStringToAnagram.containsKey(sortedString)){
                sortedStringToAnagram.put(sortedString,new ArrayList<String>());
            }   
           sortedStringToAnagram.get(sortedString).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> cur: sortedStringToAnagram.entrySet()){
            res.add(cur.getValue());
        } 
        return res;
    }
}
