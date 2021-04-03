+ ##

+ 查询两个字段的count
select paperName
, count(*) as 总题数
, sum(case when statu = 1 then 1 else 0 end) as 审核题数
from question group by paperNme
