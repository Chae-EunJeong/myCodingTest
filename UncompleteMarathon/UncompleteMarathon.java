import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<> ();
        for(String par : participant)
            hm.put(par, hm.getOrDefault(par, 0) + 1);
        
        for(String com : completion)
            hm.put(com, hm.get(com) - 1);
        
        for(String key : hm.keySet())
            if(hm.get(key) != 0)
                answer = key;
        
        return answer;
    }
}
