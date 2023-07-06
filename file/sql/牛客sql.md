## **SQL158** **每类视频近一个月的转发量/率**

https://www.nowcoder.com/practice/a78cf92c11e0421abf93762d25c3bfad?tpId=268&tqId=2285068&ru=/exam/oj&qru=/ta/sql-factory-interview/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DSQL%25E7%25AF%2587%26topicId%3D199

```sql
SELECT
	B.tag,
	SUM(A.if_retweet) AS retweet_cut,
	ROUND((SUM(A.if_retweet)/COUNT(1)),3) AS retweet_rate
FROM
	tb_user_video_log AS A
LEFT JOIN tb_video_info B ON A.video_id = B.video_id	 
WHERE
	A.start_time >= DATE_SUB((SELECT MAX(end_time) FROM tb_user_video_log),INTERVAL 30 DAY)
GROUP BY
	B.tag
ORDER BY retweet_rate DESC

```

## **SQL159** **每个创作者每月的涨粉率及截止当前的总粉丝量**

https://www.nowcoder.com/practice/d337c95650f640cca29c85201aecff84?tpId=268&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DSQL%25E7%25AF%2587%26topicId%3D199

```sql
WITH T1 AS (
	SELECT B.author, 
		DATE_FORMAT(A.start_time, '%Y-%m') AS month, 
		sum(sum(IF(A.if_follow=2,-1,A.if_follow))) over(partition by B.author order by date_format(A.start_time,'%Y-%m')) AS total_fans 
	FROM tb_user_video_log A LEFT JOIN tb_video_info B ON A.video_id = B.video_id
	WHERE year(start_time) <= 2021
	GROUP BY 	B.author, DATE_FORMAT(A.start_time, '%Y-%m')
),
T2 AS (
	SELECT
		B.author,
		DATE_FORMAT(A.start_time, '%Y-%m') AS month,
		ROUND(SUM(IF(A.if_follow=2,-1,A.if_follow)) / COUNT(1), 3) AS fans_growth_rate
	FROM tb_user_video_log A LEFT JOIN tb_video_info B ON A.video_id = B.video_id 
	WHERE year(start_time) = 2021
	GROUP BY B.author,DATE_FORMAT(A.start_time, '%Y-%m')
)
SELECT T2.*, T1.total_fans FROM T1, T2 WHERE T1.author = T2.author AND T1.month = T2.month
ORDER BY T2.author, T1.total_fans
```

