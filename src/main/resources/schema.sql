CREATE TABLE IF NOT EXISTS vets (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS specialties (
  id SERIAL PRIMARY KEY,
  name VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INT NOT NULL,
  specialty_id INT NOT NULL,
  UNIQUE (vet_id,specialty_id)
);

CREATE TABLE IF NOT EXISTS types (
  id SERIAL PRIMARY KEY,
  name VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS owners (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS pets (
  id SERIAL PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INT NOT NULL,
  owner_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS visits (
  id SERIAL PRIMARY KEY,
  pet_id INT NOT NULL,
  visit_date DATE,
  description VARCHAR(255)
);
