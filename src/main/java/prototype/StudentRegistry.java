package prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    //key, value-> key is string, value is student
    private Map<String, Student> map = new HashMap<>();
    //2 functions
    //register helps to register a key and student
    public void register(String key , Student student){
        map.put(key, student);
    }
    //get the existing registry(collection of prototype)
    public Student get(String key){
        return map.get(key);
    }
}
