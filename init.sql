CREATE EXTENSION postgis;
CREATE TABLE metro_line (id SERIAL PRIMARY KEY, line_color VARCHAR);
SELECT AddGeometryColumn('metro_line', 'line_path', 4326, 'LINESTRING', 2);

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.3340415 60.0522203, 30.322073 60.037235)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.322073 60.037235,30.317907 60.012125)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.317907 60.012125,30.2968689 60.0031367)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.2968689 60.0031367,30.2993530 59.9864298)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.2993530 59.9864298,30.3101720 59.9670183)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.3101720 59.9670183, 30.3186966 59.9562141)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.3186966 59.9562141, 30.3249537 59.9353946)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.3249537 59.9353946, 30.3201740 59.9278024)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.3201740 59.9278024, 30.3156279 59.9159900)', 4326), 'blue');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.330833 59.934444,30.360532 59.931580)', 4326), 'green');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.360532 59.931580,30.3880532 59.9246682)', 4326), 'green');

INSERT INTO metro_line (line_path, line_color)
VALUES (st_geomfromtext('LINESTRING(30.2790898 59.9432781,30.330833 59.934444)', 4326), 'green');
