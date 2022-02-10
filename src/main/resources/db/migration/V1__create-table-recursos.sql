create table recursos(
	id bigint not null auto_increment primary key,
	descricao varchar(255) not null,
	valor decimal(18,2) not null,
	data date not null
);