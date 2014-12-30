public class Solution {
    public int majorityElement(int[] num) {
        double numRequired = Math.floor(num.length / 2);
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < num.length; i++) {
            int key = new Integer(num[i]);
            if (freqMap.containsKey(key))
                freqMap.put(key, freqMap.get(key) + 1);
            else 
                freqMap.put(key, 1);
        }
        
        // Walk through the freqMap and just check the first element that appears more than [n/2] times
        for (int k : freqMap.keySet()) {
            int currCount = freqMap.get(k);
            if (currCount > numRequired) {
                return k;
            }
        }
        return -1;
    }
}
