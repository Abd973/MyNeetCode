package binary_search;

import java.util.*;

class TimeMap {

    private String key;
    private String value;
    private int timeStamp;
    public void set(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timeStamp = timestamp;
    }

    public String get(String key, int timestamp) {
        return null;
    }
}

// a brute force solution:
class TimeMap2{
    private Map<String, Map<Integer, List<String>>> keyStore;

    public TimeMap2() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key))
            keyStore.put(key, new HashMap<>());

        if (!keyStore.get(key).containsKey(timestamp))
            keyStore.get(key).put(timestamp, new ArrayList<>());

        keyStore.get(key).get(timestamp).add(value);
    }

    public String get(String key, int timestamp) {
        if(!keyStore.containsKey(key))
            return "";
        int seen = 0;
        for (int time : keyStore.get(key).keySet()) {
            if (time <= timestamp) {
                seen = Math.max(seen, time);
            }
        }
        if (seen == 0) return "";
        int back = keyStore.get(key).get(seen).size() - 1;
        return keyStore.get(key).get(seen).get(back);
    }
}

// binary search with sorted map (tree map)
class TimeMap3 {
    private Map<String, TreeMap<Integer, String>> keyStore;

    public TimeMap3() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = keyStore.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);//this entry is less than or equal to the timestamp
        return entry != null ? entry.getValue() : "";
    }
}

// binary search with array:
class TimeMap4{
    private Map<String, List<Pair<Integer, String>>> keyStore;


    public TimeMap4() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = values.size() - 1;
        String res = "";
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                res += values.get(mid).getValue();
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

public class TimeBasedKeyValueStore {
}
