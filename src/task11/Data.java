package task11;

import java.util.HashMap;
import java.util.Map;

public class Data {
    private Map<String, Object> attributes;

    public Data() {
        attributes = new HashMap<>();
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            if (entry.getValue() != null) {
                result.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
