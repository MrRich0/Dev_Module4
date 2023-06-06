SELECT c.NAME, COUNT(p.ID) AS PROJECT_COUNT FROM client c
JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.ID, c.NAME
HAVING COUNT(p.ID) = (SELECT COUNT(p.ID) AS project_count
    FROM project p
    GROUP BY p.CLIENT_ID
    ORDER BY project_count DESC
    LIMIT 1
    )