WITH SOLD_BOOKS AS (
    SELECT BOOK_ID, SUM(SALES) AS TOTAL_SOLD
    FROM BOOK_SALES
    WHERE SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31' 
    GROUP BY BOOK_ID
),

SOLD_AUTHOR AS(
    SELECT AUTHOR_ID, CATEGORY, SUM(TOTAL_SOLD * PRICE) AS TOTAL_SALES
    FROM BOOK
    JOIN SOLD_BOOKS
    ON BOOK.BOOK_ID = SOLD_BOOKS.BOOK_ID
    GROUP BY AUTHOR_ID, CATEGORY
)

SELECT AUTHOR.AUTHOR_ID, AUTHOR.AUTHOR_NAME, SOLD_AUTHOR.CATEGORY, SOLD_AUTHOR.TOTAL_SALES
FROM AUTHOR
JOIN SOLD_AUTHOR
ON AUTHOR.AUTHOR_ID = SOLD_AUTHOR.AUTHOR_ID
ORDER BY AUTHOR_ID ASC, SOLD_AUTHOR.CATEGORY DESC;