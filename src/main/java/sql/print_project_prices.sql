SELECT p.id AS id, SUM(
    w.SALARY * ABS(EXTRACT(MONTH FROM p.FINISH_DATE) - EXTRACT(MONTH FROM p.START_DATE) + 1))
    AS PRICE FROM project p
    JOIN project_worker pw ON p.ID = pw.PROJECT_ID
    JOIN worker w ON pw.WORKER_ID = w.ID
        GROUP BY p.id
        ORDER BY PRICE DESC;
