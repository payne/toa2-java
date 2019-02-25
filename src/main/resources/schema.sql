CREATE TABLE IF NOT EXISTS people (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(30),
  description VARCHAR(2048)
);

CREATE TABLE IF NOT EXISTS tags (
  id SERIAL PRIMARY KEY,
  tag VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS tagToPerson (
  id INT NOT NULL,
  person_id INT,
  tag_id INT,
  ambassador BOOLEAN default false
);


