select count(*) as FISH_COUNT 
from FISH_INFO 
where '2021' = DATE_FORMAT(TIME, '%Y');

