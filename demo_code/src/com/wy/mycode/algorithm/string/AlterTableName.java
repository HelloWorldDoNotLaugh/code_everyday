package com.wy.mycode.algorithm.string;

/**
 * @author HelloWorld
 * @create 2022/6/25 10:09
 * @email helloworld.dng@gmail.com
 */
public class AlterTableName {
    /** 表名转换规则 insert\s*into\s*\w+\((\w+,)*\s*\w+)\s*values\((\w+,)*\s*\w+) */
    private static final String SWITCH_RULE = "insert\\s*into\\s*\\w+\\s*\\((\\w+,)*\\s*\\w+\\)\\s*values\\s*\\((\\w+,)*\\s*\\w+\\)";

    /**
     * @description
     * @author HelloWorld
     * @create 2022/6/25 10:24
     * @param sql 需要转换的sql
     * @param prefix 表名前缀
     * @return java.lang.String
     */
    private String doAlterTableName(String sql, String prefix) {
        SwitchStringUtil switchStringUtil = new SwitchStringUtil();
        // insert into PD_[\w]+ \s*\((\w+,)*\s*operator)\s*values\((\w+,)*\s*TK)
        String target = "insert\\s*into\\s*\\w+\\s*\\((\\w+,)*\\s*operator\\)\\s*values\\s*\\((\\w+,)*\\s*TK\\)";
        return switchStringUtil.switchStringByRule(sql, SWITCH_RULE, target);
    }

    public static void main(String[] args) {
        String str = "insert    into     table (item1, item2) values (value1, value2)";
        AlterTableName alterTableName = new AlterTableName();
        System.out.println(alterTableName.doAlterTableName(str, "PD_"));
    }
}
