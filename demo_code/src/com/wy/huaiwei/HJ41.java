package com.wy.huaiwei;

import java.util.*;

/**
 * @author HelloWorld
 * @create 2023/7/8 16:08
 * @email helloworld.dng@gmail.com
 */
public class HJ41 {
      private static void count(int n, int[] weightArray, int[] numArray) {
        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(0);
        // 砝码的个数 乘上 砝码的重量 加和
        /*
            输入 n=2，weight={1, 2} nums={2, 1}
            when: i=0  list={0}
                 j=0, k=0 resultSet={0}
                 j=1, k=0 resultSet={0, 1}
                 j=2, k=0 resultSet={0, 1, 2}
            when: i=1 list={0, 1, 2}
                j=0, k=0
                j=0, k=1
                j=0, k=2

                j=1, k=0
                j=1, k=1
                j=1, k=2
         */
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(resultSet);
            for (int j = 0; j <= numArray[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    resultSet.add(weightArray[i] * j + list.get(k));
                }
            }
        }

        System.out.println(resultSet.size());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        count(n, weight, nums);
    }
}
