create table receitas(
	id bigint not null primary key,
	foreign key(id) references recursos(id)
);