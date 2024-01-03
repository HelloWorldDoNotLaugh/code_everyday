//package com.wy.leetcode;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static cn.hutool.core.map.MapUtil.sortByValue;
//
///**
// * @author HelloWorld
// * @date 2023/11/12 21:58
// * @email helloworld.dng@gmail.com
// */
//public class L692 {
//    public List<String> topKFrequent(String[] words, int k) {
//        // 优先队列
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            Integer value = map.getOrDefault(word, 0);
//            map.put(word, value + 1);
//        }
//
//        map = sortByValue(map, true);
//
//        return map.keySet().stream().limit(k).collect(Collectors.toList());
//    }
//
//
//    public List<String> sortMap(Map<String, Integer> map) {
//        LinkedList<String> list = new LinkedList<>();
//        map.forEach((key, value) -> {
//            if (list.size() == 0) {
//                list.add(String.format("%s_%s", value, key));
//            }
//
//        });
//    }
//
//    private int destination(List<String> list, String key, Integer value) {
//        int left = 0;
//        int right = list.size() - 1;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            int midValue = Integer.parseInt(list.get(mid).split("_")[0]);
//            String midKey = list.get(mid).split("_")[1];
//
//            if (midValue >= value) {
//
//            }
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        for (String s : new L692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)) {
//            System.out.println(s);
//        }
//
//    }
//
//
//}
