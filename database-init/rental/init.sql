CREATE TABLE IF NOT EXISTS public.rentals (
	id uuid NOT null primary key,
	machine_id uuid NOT NULL,
	customer_id uuid NOT NULL,
	date_from date NOT NULL,
	date_to date NOT NULL
);

INSERT INTO public.rentals(id, machine_id, customer_id, date_from, date_to)  
	VALUES('2a51abcc-0a02-4e1a-b2d8-ee0163cf6b45', '751f81e9-5ab5-4afb-809b-4a12f5b41713', 
		   '522eead0-ad0a-4543-92f9-d6bb4954748b', '2024-01-01', '2025-02-04');

INSERT INTO public.rentals(id, machine_id, customer_id, date_from, date_to)  
	VALUES('b155fce1-04c9-407b-92ff-2e20dc0d003a', 'ab444919-90f8-42a5-a051-8ebe2a9993a1', 
		   '962d7524-ee33-421a-ab56-43fe0cf7c515', '2023-06-23', '2024-09-13');

INSERT INTO public.rentals(id, machine_id, customer_id, date_from, date_to)  
	VALUES('b8359cc8-b641-4ba2-b149-2a3d4c0e5a90', '92695b78-9266-4e3a-bd28-af509705ff12', 
		   '7b2bae7a-22e7-468b-af5c-e91e05d52183', '2023-01-23', '2024-01-13');

INSERT INTO public.rentals(id, machine_id, customer_id, date_from, date_to)  
	VALUES('b8359cc8-b641-4ba2-b149-2a3d4c0e5a91', '92695b78-9266-4e3a-bd28-af509705ff12', 
		   '8b1f749a-7c5b-4a85-8edc-037a49432b95', '2023-11-28', '2023-02-15');