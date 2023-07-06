package com.wy.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HelloWorld
 * @create 2022/5/1 19:58
 * @email helloworld.dng@gmail.com
 */
public class FindPrimePartner {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        Number number = new Number(1, integers);
        number.partnerList.remove((Integer) 2);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numberList = new ArrayList<>();
        while (n-- > 0) {
            numberList.add(scanner.nextInt());
        }

        // 打印有多少对素数伴侣
        System.out.println(doFindPrimePartner(numberList));
    }


    /**
     * 素数伴侣
     *
     * @param numberList
     * @return int
     * @description
     * @author HelloWorld
     * @create 2022/5/2 08:39
     */
    public static int doFindPrimePartner(List<Integer> numberList) {
        /* 第一步：分组；奇数组，偶数组；*/
        // 奇数组
        ArrayList<Integer> oddList = new ArrayList<>();
        // 偶数组
        ArrayList<Integer> evenList = new ArrayList<>();
        for (Integer integer : numberList) {
            if (integer % 2 == 0) {
                evenList.add(integer);
            } else {
                oddList.add(integer);
            }
        }
        /* 第二步：列举每个数据的全部伴侣 */
        List<Number> evenNumbers = getPartnerList(evenList, oddList);
        List<Number> oddNumbers = getPartnerList(oddList, evenList);

        // 素数伴侣计数器
        int sum = 0;
        /*
            第三步：分配伴侣
                1. 遍历evenNumbers。给evenNumbers中的每个数据分配伴侣
                2. 优先给 可匹配伴侣数最少的分配伴侣。
        */

        List<Number> largeNumbers = evenNumbers.size() > oddNumbers.size() ? evenNumbers : oddNumbers;
        List<Number> smallNumbers = evenNumbers.size() < oddNumbers.size() ? evenNumbers : oddNumbers;

        while (true) {

            // 从largeNumbers中取出一个 partnerNum 最小的
            Number largeNumber = largeNumbers.stream()
                    .filter(number -> number.getPartnerNum() > 0)
                    .sorted(Comparator.comparing(Number::getPartnerNum))
                    .findFirst()
                    .orElse(new Number());
            int a = largeNumber.value;

            // 先给可分配伴侣数最少的分配，如果有多个一样多，则先给 含有 largeNumber.value分配

            // smallNumbers 按 partnerNum 递增 排序
            smallNumbers = smallNumbers.stream()
                    .filter(number -> number.getPartnerNum() > 0)
                    .sorted(Comparator.comparing(Number::getPartnerNum))
                    .collect(Collectors.toList());

            if (smallNumbers.size() == 0) {
                break;
            }
            Number smallNumber = new Number();
            // 分配伴侣
            Integer partner = largeNumber.value;
            for (int i = 0; i < smallNumbers.size(); i++) {
                if (i == smallNumbers.size() - 1) {
                    smallNumber = smallNumbers.get(i);
                    if (!smallNumbers.get(i).partnerList.contains(smallNumber)) {
                        partner = smallNumber.partnerList.stream().findFirst().get();
                        break;
                    }
                }

                if (smallNumbers.get(i).getPartnerNum() == smallNumbers.get(i + 1).getPartnerNum()) {
                    if (smallNumbers.get(i).partnerList.contains(smallNumber)) {
                        smallNumber = smallNumbers.get(i);
                        break;
                    }
                } else {
                    smallNumber = smallNumbers.get(i);
                    if (!smallNumber.partnerList.contains(partner)) {
                        partner = smallNumber.partnerList.stream().findFirst().get();
                    }
                    break;
                }
            }
            // 将已经分配伴侣的元素移除
            if (partner == 18853) {
                int b = 0;
            }
            removeNumber(smallNumbers, smallNumber, partner);
            if (!partner.equals(largeNumber.value)) {
                for (Number number : largeNumbers) {
                    if (partner.equals(number.value)) {
                        largeNumber = number;
                        break;
                    }
                }
            }
            removeNumber(largeNumbers, largeNumber, smallNumber.value);
            sum++;
        }
        return sum;

    }

    /**
     * @param numbers
     * @param number
     * @param partner
     * @return void
     * @description 移除指定元素
     * @author HelloWorld
     * @create 2022/5/2 17:47
     */
    public static void removeNumber(List<Number> numbers, Number number, Integer partner) {
        numbers.remove(number);
        numbers.stream()
                .forEach(number1 -> {
                    if (number1.partnerList.contains(partner)) {
                        number1.partnerList.remove(partner);
                        number1.partnerNum = number1.partnerNum - 1;
                    }
                });
    }


    /**
     * @param listA
     * @param listB
     * @return java.util.List<com.wy.leetcode.Number>
     * @description 为集合A中的每个数据匹配伴侣
     * @author HelloWorld
     * @create 2022/5/2 16:51
     */
    public static List<Number> getPartnerList(List<Integer> listA, List<Integer> listB) {
        ArrayList<Number> resultList = new ArrayList<>();
        for (Integer a : listA) {
            ArrayList<Integer> partnerList = new ArrayList<>();
            for (Integer b : listB) {
                if (isPrime(a + b)) {
                    partnerList.add(b);
                }
            }
            resultList.add(new Number(a, partnerList));
        }

        return resultList;
    }

    /**
     * @param number
     * @return void
     * @description 判断一个数是否是素数
     * @author HelloWorld
     * @create 2022/5/1 20:13
     */
    public static boolean isPrime(int number) {
        /*
            输入的数据 >= 2, 两个数的和一定大于2，所以可以把 2 排除掉；
         */
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

class Number {
    int value;
    ArrayList<Integer> partnerList;
    int partnerNum;

    public Number() {
    }

    public Number(int value, ArrayList<Integer> partnerList) {
        this.value = value;
        this.partnerList = partnerList;
        this.partnerNum = this.partnerList.size();
    }

    public int getPartnerNum() {
        return partnerNum;
    }
}
