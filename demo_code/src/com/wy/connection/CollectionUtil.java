package com.wy.connection;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HelloWorld
 * @create 2022/11/19 16:07
 * @email helloworld.dng@gmail.com
 */
public class CollectionUtil {
    /** 集合拆分，每3个拆成一个小集合*/
    private static final int SIZE = 3;

    public static<T> Set<Set<T>> split(Collection<T> collection) {
        return Stream.iterate(0, n -> n + 1)
                .limit(collection.size() / SIZE + 1)
                .map(i -> collection.stream().skip(i * SIZE).limit(SIZE).collect(Collectors.toSet()))
                .filter(CollUtil::isNotEmpty)
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) {
        Set<Set<Integer>> split = split(Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8));
        for (Set<Integer> integers : split) {
            for (Integer integer : integers) {
                System.out.print(integer);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
