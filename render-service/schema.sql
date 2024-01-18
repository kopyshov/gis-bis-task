CREATE EXTENSION postgis;
CREATE TABLE metro_line (id SERIAL PRIMARY KEY, line_color VARCHAR);
SELECT AddGeometryColumn('metro_line', 'line_path', 4326, 'LINESTRING', 2);
