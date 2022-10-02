CREATE TABLE member
(
    id         CHAR(36) PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP   NOT NULL DEFAULT current_timestamp
);

CREATE TABLE member_order
(
    id           CHAR(36) PRIMARY KEY,
    order_no     VARCHAR(20) NOT NULL,
    member_id    CHAR(36)    NOT NULL,
    amount       NUMERIC     NOT NULL,
    product_id   CHAR(36)    NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    description  VARCHAR(100) NULL,
    created_at   TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    updated_at   TIMESTAMP   NOT NULL DEFAULT current_timestamp
);
