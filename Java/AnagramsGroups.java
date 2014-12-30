import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class AnagramsGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = {"dog", "god", "ban", "abn"};
		ArrayList<String> strList = new ArrayList<String>();
		strList = anagrams(strs);
		for (String s : strList) {
			System.out.print(s);
			System.out.print(" ");
		}
	}
	
  public static ArrayList<String> anagrams(String[] strs) {
        if(strs.length < 2) return new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(String str : strs) {
            String key = sortChars(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            ArrayList<String> anagrams = map.get(key);
            anagrams.add(str);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for(String key : map.keySet()) {
            ArrayList<String> anagrams = map.get(key);
            if(anagrams.size() > 1) {
                result.addAll(anagrams);            
            }
        }
        
        return result;
    }
    
    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
     /*public static ArrayList<String> anagrams(String[] strs) {
        HashMap<String, HashMap<Character, Integer>> strCharsMap
            = new HashMap<String, HashMap<Character, Integer>>();
        HashMap<HashMap<Character, Integer>, Integer> charsCountMap
            = new HashMap<HashMap<Character, Integer>, Integer>();
        for(String s : strs) {
            HashMap<Character, Integer> map =
                new HashMap<Character, Integer>();
            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                map.put(c, map.get(c) == null ? 1 : map.get(c)+1);
            }
            strCharsMap.put(s, map);
            charsCountMap.put(map, charsCountMap.get(map) == null ?
                                1 : charsCountMap.get(map) + 1);
        }
         
        ArrayList<String> sol = new ArrayList<String>();
        for(String s : strs) {
            if(charsCountMap.get(strCharsMap.get(s)) > 1)
                sol.add(s);
        }
        return sol;
         
    }*/

}
