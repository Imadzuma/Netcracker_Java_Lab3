CREATE TABLE IF NOT EXISTS customers2 (
	id SERIAL PRIMARY KEY,
	last_name TEXT NOT NULL,
	district TEXT NOT NULL,
	sale DOUBLE PRECISION NOT NULL
);

INSERT INTO customers2(last_name, district, sale) VALUES('Ivanov', 'Nizhegorodskiy', 0.15);
INSERT INTO customers2(last_name, district, sale) VALUES('Petrov', 'Nizhegorodskiy', 0.05);
INSERT INTO customers2(last_name, district, sale) VALUES('Romanova', 'Avtozavodskiy', 0.005);
INSERT INTO customers2(last_name, district, sale) VALUES('Morozova', 'Avtozavodskiy', 0.15);
INSERT INTO customers2(last_name, district, sale) VALUES('Stepanov', 'Sovetskiy', 0.0245);
