create table despesas(
	id bigint not null primary key,
	foreign key(id) references recursos(id)
);