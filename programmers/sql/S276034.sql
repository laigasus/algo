# SKILLCODES 프로그래밍 언어 모음
# DEVELOPERS 개발자 정보
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE EXISTS (
    SELECT CODE 
    FROM SKILLCODES 
    WHERE NAME IN ('Python', 'C#')
    AND DEVELOPERS.SKILL_CODE & SKILLCODES.CODE = SKILLCODES.CODE
)
ORDER BY ID ASC;