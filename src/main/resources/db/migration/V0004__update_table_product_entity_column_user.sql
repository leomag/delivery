ALTER TABLE product_entity
    ALTER COLUMN username TYPE INTEGER
        USING username::integer
;

ALTER TABLE product_entity
    RENAME COLUMN username TO user_id;