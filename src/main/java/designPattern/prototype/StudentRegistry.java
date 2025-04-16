package designPattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    Map<String, Student> studentMap = new HashMap<>();

    //use 2 functionalities -  register a prototype(both key and student), then get a prototype according to the name of the prototype
    public void register(String key, Student student){
        studentMap.put(key, student);
    }

    public Student get(String key){
        return studentMap.get(key);
    }
}
