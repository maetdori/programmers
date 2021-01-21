import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>(cacheSize);
        int time = 0;
        
        for(String city: cities) {
            String cityLow = city.toLowerCase();
            if(!cache.isEmpty() && cache.contains(cityLow)) { 
                cache.remove(cityLow);
                cache.add(cityLow);
                time += 1;
            }
            
            else {
                cache.add(cityLow);
                if(cache.size() > cacheSize)
                    cache.remove(0);
                time += 5;
            }
        }
        return time;
    }
}