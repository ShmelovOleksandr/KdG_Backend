insert into sellers(seller_id, name, address)
values ('ddf45d07-948e-4cdc-b93e-4a02e9337415', 'AP', 'Beststreet, 1');

insert into customers (customer_id, address, name)
values ('fff45d07-948e-4cdc-b93e-4a02e9337415', 'UAntw', 'Beststreet, 2');

insert into pos (date, customer_id, po_id, seller_id, po_number, vessel_number)
values ('2024-10-28', 'fff45d07-948e-4cdc-b93e-4a02e9337415', '12345d07-948e-4cdc-b93e-4a02e9337415', 'ddf45d07-948e-4cdc-b93e-4a02e9337415', 'PO123456', 'VSL7891011');

insert into oreder_items (line_number, quantity, order_item_id, po_id, description, material_type, uom)
values (1, 100, '00145d07-948e-4cdc-b93e-4a02e9337415', '12345d07-948e-4cdc-b93e-4a02e9337415', 'Petcoke', 'PETCOKE', 'KT'),
       (1, 50, '20245d07-948e-4cdc-b93e-4a02e9337415', '12345d07-948e-4cdc-b93e-4a02e9337415', 'Slag', 'SLAG', 'KT');

insert into warehouses (id, owner_id, material_type)
values ('1df45d07-948e-4cdc-b93e-4a02e9337415', 'ddf45d07-948e-4cdc-b93e-4a02e9337415', 'PETCOKE'),
       ('25b63a57-c1d7-4a8d-a3e7-62feebbc9d3f', 'ddf45d07-948e-4cdc-b93e-4a02e9337415', 'SLAG');