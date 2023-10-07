# if消除术之 Map + Function

## 需求描述

设计一个简易计算器，只支持 a+b, a-b, a*b, a/b

## 具体实现

利用Map，key是具体的加减乘除操作，value是一个Function

```java
package com.wy.ifkiller;

import cn.hutool.core.map.MapUtil;

import java.util.Map;
import java.util.function.BiFunction;

import static com.wy.ifkiller.FunctionMap.Action.ADD;
import static com.wy.ifkiller.FunctionMap.Action.DIV;
import static com.wy.ifkiller.FunctionMap.Action.MUL;
import static com.wy.ifkiller.FunctionMap.Action.SUB;

/**
 * @author HelloWorld
 * @date 2023/10/7 17:21
 * @email helloworld.dng@gmail.com
 */
public class FunctionMap {
    private Map<Action, BiFunction<Integer, Integer, Integer>> getActionMap() {
        return MapUtil.<Action, BiFunction<Integer, Integer, Integer>>builder()
                .put(ADD, this::add)
                .put(SUB, this::sub)
                .put(MUL, this::mul)
                .put(DIV, this::div)
                .map();
    }

    public static void main(String[] args) {
        FunctionMap functionMap = new FunctionMap();
        Map<Action, BiFunction<Integer, Integer, Integer>> actionMap = functionMap.getActionMap();

        System.out.println(actionMap.get(ADD).apply(3, 2));
        System.out.println(actionMap.get(SUB).apply(3, 2));
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }

    private int mul(int a, int b) {
        return a * b;
    }

    private int div(int a, int b) {
        return a / b;
    }

    enum Action {
        ADD,
        SUB,
        MUL,
        DIV;
    }
}
```



