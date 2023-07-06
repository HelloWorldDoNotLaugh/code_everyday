package com.wy.new_features;

import com.wy.other.printSchema.StudentSchema;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StreamDemo {
    public Map<String, StudentSchema> getMap(List<StudentSchema> list) {
        return list.stream().filter(studentSchema -> {
            ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
            return map.putIfAbsent(studentSchema.getName(), Boolean.TRUE);
        }).collect(Collectors.toMap(StudentSchema::getName, StudentSchema -> StudentSchema));
    }
    public static void main(String[] args) {

    }
}
