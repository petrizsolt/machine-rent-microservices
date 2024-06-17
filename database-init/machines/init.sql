CREATE TABLE IF NOT EXISTS public.machines (
	id uuid NOT null primary key,
	name varchar(255) NOT NULL
);

INSERT INTO public.machines(id, "name")  VALUES('751f81e9-5ab5-4afb-809b-4a12f5b41713', 'Intel Xeon v1');
INSERT INTO public.machines(id, "name")  VALUES('ab444919-90f8-42a5-a051-8ebe2a9993a1', 'HP elitebook 6655');
INSERT INTO public.machines(id, "name")  VALUES('92695b78-9266-4e3a-bd28-af509705ff12', 'Apple Macbook pro');
INSERT INTO public.machines(id, "name")  VALUES('92695b78-9266-4e3a-bd28-af509705ff13', 'AppleBook v2');