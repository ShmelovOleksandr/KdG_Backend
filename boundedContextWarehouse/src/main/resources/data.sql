insert into sellers(id) values ('ddf45d07-948e-4cdc-b93e-4a02e9337415');

insert into warehouse_activity_windows (warehouse_id)
values ('1df45d07-948e-4cdc-b93e-4a02e9337415'),
       ('25b63a57-c1d7-4a8d-a3e7-62feebbc9d3f');
--
insert into warehouses (current_capacity, material_type_stored, max_capacity, seller_id, warehouse_activity_window_id, id)
values (0, 'PETCOKE', 500000, 'ddf45d07-948e-4cdc-b93e-4a02e9337415', '1df45d07-948e-4cdc-b93e-4a02e9337415', '1df45d07-948e-4cdc-b93e-4a02e9337415'),
       (0, 'SLAG', 500000, 'ddf45d07-948e-4cdc-b93e-4a02e9337415', '25b63a57-c1d7-4a8d-a3e7-62feebbc9d3f', '25b63a57-c1d7-4a8d-a3e7-62feebbc9d3f');

