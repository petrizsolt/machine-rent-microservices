CREATE TABLE IF NOT EXISTS public.customers (
	id uuid NOT null primary key,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	company_name varchar(255) NULL,
	"type" varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	phone varchar(50) NOT NULL
);

INSERT INTO public.customers(id, first_name, last_name, company_name, "type", address, phone)  
	VALUES('522eead0-ad0a-4543-92f9-d6bb4954748b', null, null, 'Google ltd', 'COMPANY',  'United states', '15644468');

INSERT INTO public.customers(id, first_name, last_name, company_name, "type", address, phone)  
	VALUES('7b2bae7a-22e7-468b-af5c-e91e05d52183', null, null, 'LIDL kft', 'COMPANY',  'Debrecen csapó u 25', '06-30-44566');

INSERT INTO public.customers(id, first_name, last_name, company_name, "type", address, phone)  
	VALUES('8b1f749a-7c5b-4a85-8edc-037a49432b95', 'Michael', 'Peterson', null, 'PERSON',  'New york longstreet 23', '06-50-14566');
	
INSERT INTO public.customers(id, first_name, last_name, company_name, "type", address, phone)  
	VALUES('962d7524-ee33-421a-ab56-43fe0cf7c515', 'Szabó', 'Gyula', null, 'PERSON',  'Szeged vándor u 65', '06-50-214556');