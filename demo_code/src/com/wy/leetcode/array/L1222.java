package com.wy.leetcode.array;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * @author HelloWorld
 * @date 2023/9/14 09:44
 * @email helloworld.dng@gmail.com
 */
public class L1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        HashMap<AttackWay, Map<Boolean, AttackQueen>> map = new HashMap<>();
        for (int[] queen : queens) {
            AttackWay attackWay = AttackWay.getAttackWay(queen, king);
            if (attackWay.equals(AttackWay.N)) {
                continue;
            }

            Boolean ahead = attackWay.aheadBiPredicate.test(queen, king);
            Integer distance = attackWay.distance.apply(queen, king);
            AttackQueen attackQueen = new AttackQueen(distance, queen);

            if (map.containsKey(attackWay)) {
                Map<Boolean, AttackQueen> booleanAttackQueenMap = map.get(attackWay);
                AttackQueen currentAttackQueen = booleanAttackQueenMap.getOrDefault(ahead, null);
                booleanAttackQueenMap.put(ahead, attackQueen.refresh(currentAttackQueen, distance, queen, ahead));
            } else {
                HashMap<Boolean, AttackQueen> booleanAttackQueenHashMap = new HashMap<>();
                booleanAttackQueenHashMap.put(ahead, attackQueen);
                map.put(attackWay, booleanAttackQueenHashMap);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map<Boolean, AttackQueen> value : map.values()) {
            for (AttackQueen attackQueen : value.values()) {
                List<Integer> list = new ArrayList<>();
                list.add(attackQueen.getQueen()[0]);
                list.add(attackQueen.getQueen()[1]);
                result.add(list);
            }
        }

        return result;
    }

    enum AttackWay{
        X("同一行", (queen, king) -> queen[1] - king[1] > 0, (queen, king) -> queen[1] - king[1]),
        Y("同一列", (queen, king) -> queen[0] - king[0] > 0, (queen, king) -> queen[0] - king[0]),

        /** 正对角线 \ */
        Z_UP("正对角线", (queen, king) -> queen[1] > king[1], (queen, king) -> queen[1] - king[1]),

        /** 斜对角线 / */
        Z_DOWN("斜对角线", (queen, king) -> queen[1] > king[1], (queen, king) -> queen[1] - king[1]),
        N("攻击不到", null, null);

        String des;

        BiPredicate<int[], int[]> aheadBiPredicate;

        BiFunction<int[], int[], Integer> distance;

        AttackWay() {
        }

        AttackWay(String des, BiPredicate<int[], int[]> aheadBiPredicate, BiFunction<int[], int[], Integer> distance) {
            this.des = des;
            this.aheadBiPredicate = aheadBiPredicate;
            this.distance = distance;
        }

        public static AttackWay getAttackWay(int[] queen, int[] king) {
            if (queen[0] == king[0]) {
                return X;
            }

            if (queen[1] == king[1]) {
                return Y;
            }

            if (Math.abs(queen[0]-king[0]) == Math.abs( queen[1]-king[1])) {
                if ((queen[0] > king[0] && queen[1] > king[1]) || (queen[0] < king[0] && queen[1] < king[1])) {
                    return Z_DOWN;
                } else {
                    return Z_UP;
                }
            }

            return N;
        }
    }

    static class AttackQueen {
        int distance;
        int[] queen;

        public AttackQueen(int distance, int[] queen) {
            this.distance = distance;
            this.queen = queen;
        }

        public int[] getQueen() {
            return queen;
        }

        public AttackQueen refresh(AttackQueen cur, int distance, int[] queen, boolean ahead) {
            if (null == cur) {
                return new AttackQueen(distance, queen);
            }

            boolean aheadAndCloser = ahead && distance < cur.distance;
            boolean backAndCloser = !ahead && distance > cur.distance;

            boolean shouldFresh = aheadAndCloser || backAndCloser;
            if (shouldFresh) {
                return new AttackQueen(distance, queen);
            }

            return cur;
        }
    }


    public static void main(String[] args) {
        L1222 l1222 = new L1222();
        l1222.queensAttacktheKing(getData("[[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]]"), new int[]{3,4});
    }

    private static int[][] getData(String data) {
        ArrayList<int[]> list = new ArrayList<>();
        for (String s : data.split("],")) {
            String[] strings = s.replace("[", "").replace("]", "").split(",");
            int[] ints = {Integer.parseInt(strings[0]), Integer.parseInt(strings[1])};
            list.add(ints);
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
