CREATE DATABASE projects_db ENCODING = 'UTF8' CONNECTION LIMIT = - 1;

CREATE USER projects_pg WITH PASSWORD 'projects_pg';

GRANT ALL PRIVILEGES ON DATABASE projects_db TO projects_pg;

\c projects_db

CREATE SCHEMA projects AUTHORIZATION projects_pg;

\q