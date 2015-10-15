drop database if exists orderhang;
create database orderhang;

use orderhang;

create table user (
	id int auto_increment primary key not null,
	username varchar(50) unique not null,
	password varchar(100) unique not null,
	is_active bit default 1,
	role_id int,
	date_created datetime default current_timestamp
);

create table role (
	id int primary key not null,
	title varchar(50)
);

create table product (
	id int auto_increment primary key not null,
	link_source varchar(500),
	shop_name varchar(200),
	color varchar(30),
	notes varchar(500),
	size varchar(10),
	quantity int,
	price int,
	status_id int,
	order_id int,
	date_created datetime default current_timestamp
);


create table order_bill (
	id int auto_increment primary key not null,
	customer_id int,
	staff_id int,
	status_id int,
	date_created datetime default current_timestamp
);

create table status (
	id int primary key not null,
	title varchar(50)
);


-- ALTER --

-- -- auto_increment --
alter table user auto_increment = 1000;

alter table product auto_increment = 1000;

alter table order_bill auto_increment = 1000;
-- -- auto_increment end --

-- -- Constraint --

alter table user add constraint fk_UserRole foreign key (role_id) references role(id);

alter table product add constraint fk_ProductStatus foreign key (status_id) references status(id);

alter table product add constraint fk_ProductOrder foreign key (order_id) references order_bill(id);

alter table order_bill add constraint fk_OrderStatus foreign key (status_id) references status(id);

alter table order_bill add constraint fk_OrderCustomerId foreign key (customer_id) references user(id);

alter table order_bill add constraint fk_OrderStaffId foreign key (staff_id) references user(id);
-- -- Constraint End --
-- ALTER END --