SELECT NAME, COUNT(*) as COUNT
FROM ANIMAL_INS 
GROUP BY NAME 
HAVING COUNT(NAME) >= 2
ORDER BY NAME;