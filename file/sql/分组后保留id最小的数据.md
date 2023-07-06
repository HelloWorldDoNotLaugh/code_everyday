## 题目描述

[[196. 删除重复的电子邮箱](https://leetcode.cn/problems/delete-duplicate-emails/)](https://leetcode.cn/problems/delete-duplicate-emails/)

## 方法1 not in

```sql
DELETE FROM Person
WHERE id NOT IN(
    SELECT
        id
    FROM (
        SELECT
            MIN(id) as id
            FROM Person
            Group by email
    )t
)

```

## 方法2 自连接

```sql
DELETE u
FROM Person u, Person v
WHERE v.id < u.id
AND v.email = u.email
```

## 方法三 窗口函数

```sql
DELETE FROM Person
WHERE id IN (
    SELECT 
        id
    FROM(
        SELECT
            id,
            dense_rank() over(partition by email order by id) as `rank`
        FROM Person
    )AS tmp
    WHERE tmp.rank>1
)
```

