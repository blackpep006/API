package task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import common.CustomException;
import common.Helper;

public class Process {
    public <K,V> Map<K,V> createMap() {
        return new HashMap<K,V>();
    }

    public <K,V> int length(Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.size();
    }

    public <K,V> boolean containsKey(K key, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.containsKey(key);
    }

    public <K,V> boolean containsValue(V value, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.containsValue(value);
    }

    public <K,V> V put(K key, V value, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.put(key, value);
    }

    public <K,V> boolean replace(K key, V old, V newValue, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.replace(key, old, newValue);
    }

    public <K,V> V get(K key, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.get(key);
    }

    public <K,V> Set<K> keySet(Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.keySet();
    }

    public <K,V> V getOrDefault(K key, V defaultValue, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.getOrDefault(key, defaultValue);
    }

    public <K,V> V remove(K key, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.remove(key);
    }

    public <K,V> boolean remove(K key, V value, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.remove(key, value);
    }

    public <K,V> V replace(K key, V newValue, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.replace(key, newValue);
    }

    public <K,V> void putAll(Map<K,V> newMap, Map<K,V> map) throws CustomException {
        Helper.validate(map);
        Helper.validate(newMap);
        map.putAll(newMap);
    }

    public <K,V> Set<Map.Entry<K,V>> entrySet(Map<K,V> map) throws CustomException {
        Helper.validate(map);
        return map.entrySet();
    }

    public <K,V> void clear(Map<K,V> map) throws CustomException {
        Helper.validate(map);
        map.clear();
    }
}
