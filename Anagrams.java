import java.util.*;

public class Anagrams {
	  public static List<Integer> allAnagrams(String s, String l) {
	    // Write your solution here.
	    List<Integer> result = new ArrayList<>();
	    if (s == null || s.length() == 0 || l == null || l.length() == 0) return result;
	    
	    HashMap<Character, Integer> eleMap = mapify(s);
	    int winL = -1;
	    int winR = -1;
	    int eleMatch = 0;
	    while (winR < l.length() - 1) {
	      winR++;
	      char rEnd = l.charAt(winR);
	      Integer count = eleMap.get(rEnd);
	      if (count != null) {
	        eleMap.put(rEnd, count - 1);
	        if (count == 1) {
	          eleMatch++;
	        }
	      }
	      if (winR >= s.length()) {
	        winL++;
	        char lEnd = l.charAt(winL);
	        count = eleMap.get(lEnd);
	        if (count != null) {
	          eleMap.put(lEnd, count + 1);
	          if (count == 0) {
	            eleMatch--;
	          }
	        }
	      }
	      if (eleMatch == eleMap.size()) {
	        result.add(winR - s.length() + 1);
	      }
	    }
	    return result;
	  }
	  
	  private static HashMap<Character, Integer> mapify(String s) {
	    HashMap<Character, Integer> result = new HashMap<>();
	    for (int i = 0; i < s.length(); i++) {
	      Integer count = result.get(s.charAt(i));
	      if (count == null) {
	        result.put(s.charAt(i), 1);
	      } else {
	        result.put(s.charAt(i), count + 1);
	      }
	    }
	    return result;
	  }
	  public static void main(String[] args) {
		  String l = "bcdefg";
		  String s = "a";
		  List<Integer> result = Anagrams.allAnagrams(s, l);
		  int idle = 0;
	  }
	}