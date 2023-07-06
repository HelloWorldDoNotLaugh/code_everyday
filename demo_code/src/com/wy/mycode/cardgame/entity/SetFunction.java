package com.wy.mycode.cardgame.entity;

public class SetFunction {
    public static void main(String[] args) throws Exception{
        CardEntity cardEntity = new CardEntity();
        set(cardEntity, "Name", "张三");
        set(cardEntity, "Age", 11);

        System.out.println(cardEntity);
    }

    private static void set(CardEntity cardEntity, String columnName, Object value) throws Exception{
        cardEntity.getClass()
                .getMethod("set" + columnName, value.getClass())
                .invoke(cardEntity, value);
    }
}
