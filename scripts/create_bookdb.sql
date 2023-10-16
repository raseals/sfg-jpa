--
-- Create USER as postgres (root / sysadmin) user
--

CREATE USER bookadmin WITH PASSWORD 'adminpassword';
CREATE USER bookuser WITH PASSWORD 'userpassword';

--
-- Create DATABASE as postgres (root / sysadmin) user
--

CREATE DATABASE bookdb;

GRANT ALL PRIVILEGES ON DATABASE bookdb to bookadmin;

GRANT CONNECT ON DATABASE bookdb TO bookuser;

REVOKE CREATE ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON DATABASE bookdb FROM PUBLIC;

\c bookdb

CREATE EXTENSION IF NOT EXISTS postgis;

CREATE SCHEMA IF NOT EXISTS bookstore AUTHORIZATION bookadmin;
GRANT ALL PRIVILEGES ON SCHEMA bookstore TO bookadmin;

--ALTER DEFAULT PRIVILEGES
--FOR USER bookuser
--IN SCHEMA bookstore
--GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO bookuser;

-- Connect to bookdb as bookadmin
\c bookdb bookadmin

CREATE SCHEMA IF NOT EXISTS bookstore AUTHORIZATION bookadmin;

CREATE TABLE IF NOT EXISTS bookstore.book
(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    isbn VARCHAR NOT NULL,
    publisher VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS bookstore.sensor
(
    id SERIAL PRIMARY KEY,
    type VARCHAR NOT NULL,
    sensor_pos_x REAL,
    sensor_pos_y REAL,
    sensor_pos_z REAL
);

GRANT USAGE ON SCHEMA bookstore TO bookuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA bookstore TO bookuser;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA bookstore TO bookuser;
