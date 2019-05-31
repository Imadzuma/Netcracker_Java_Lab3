CREATE TABLE IF NOT EXISTS customers (
	id SERIAL PRIMARY KEY,
	last_name TEXT NOT NULL,
	district TEXT NOT NULL,
	sale DOUBLE PRECISION NOT NULL
);

CREATE TABLE IF NOT EXISTS shops (
	id SERIAL NOT NULL PRIMARY KEY,
	name TEXT NOT NULL,
	district TEXT NOT NULL,
	commission DOUBLE PRECISION NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
	id SERIAL NOT NULL PRIMARY KEY,
	name TEXT NOT NULL,
	price INTEGER NOT NULL,
	storage TEXT NOT NULL,
	count INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
	id SERIAL NOT NULL PRIMARY KEY,
	date DATE NOT NULL,
	seller INTEGER NOT NULL REFERENCES shops(id),
	customer INTEGER NOT NULL REFERENCES customers(id),
	book INTEGER NOT NULL REFERENCES books(id) ,
	count INTEGER NOT NULL,
	cost INTEGER NOT NULL
);

INSERT INTO customers(last_name, district, sale) VALUES('Ivanov', 'Nizhegorodskiy', 0.15);
INSERT INTO customers(last_name, district, sale) VALUES('Petrov', 'Nizhegorodskiy', 0.05);
INSERT INTO customers(last_name, district, sale) VALUES('Romanova', 'Avtozavodskiy', 0.005);
INSERT INTO customers(last_name, district, sale) VALUES('Morozova', 'Avtozavodskiy', 0.15);
INSERT INTO customers(last_name, district, sale) VALUES('Stepanov', 'Sovetskiy', 0.0245);

INSERT INTO shops(name, district, commission) VALUES('Dom Knigi', 'Nizhegorodskiy', 4);
INSERT INTO shops(name, district, commission) VALUES('Chitayna', 'Avtozavodskiy', 10);
INSERT INTO shops(name, district, commission) VALUES('Chitay-gorod', 'Sovetskiy', 5);
INSERT INTO shops(name, district, commission) VALUES('Books', 'Sormovskiy', 5);

INSERT INTO books (name, price, storage, count) VALUES('Master And Margarita', 1830, 'Nizhegorodskiy', 12);
INSERT INTO books (name, price, storage, count) VALUES('War and Peace', 1000, 'Avtozavodskiy', 21);
INSERT INTO books (name, price, storage, count) VALUES('Lord of the Rings', 1450, 'Sovetskiy', 33);
INSERT INTO books (name, price, storage, count) VALUES('Crime and Punishment', 455, 'Avtozavodskiy', 12);
INSERT INTO books (name, price, storage, count) VALUES('Dead souls', 645, 'Avtozavodskiy', 43);
INSERT INTO books (name, price, storage, count) VALUES('Eugene Onegin', 1290, 'Nizhegorodskiy', 5);
INSERT INTO books (name, price, storage, count) VALUES('Harry Potter', 1500, 'Sovetskiy', 33);
INSERT INTO books (name, price, storage, count) VALUES('The Witcher', 3400, 'Nizhegorodskiy', 34);
INSERT INTO books (name, price, storage, count) VALUES('Windows XP' ,1500 ,'Sovetskiy' ,3);

INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-02-01', 1, 1, 8, 20, 64000);
INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-02-25', 4, 2, 5, 3, 5003);
INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-04-04', 1, 3, 7, 1, 5000);
INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-05-05', 2, 3, 9, 1, 1245);
