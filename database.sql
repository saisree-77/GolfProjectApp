CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE subscriptions (
    sub_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    plan_type VARCHAR(50),
    status VARCHAR(20),
    start_date DATE,
    end_date DATE
);

CREATE TABLE scores (
    score_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    score INT,
    game_date DATE
);

