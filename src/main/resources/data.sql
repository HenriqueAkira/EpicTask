CREATE TABLE TASK (
    id int PRIMARY KEY auto_increment,
    title varchar(200),
    description TEXT,
    points int
);

INSERT INTO TASK VALUES(1, 'Criar Banco de dados','Criar o banco de dados na nuvem', 50);
INSERT INTO TASK VALUES(2, 'Protótipo','Prototipação de alta fidelidade', 30);
INSERT INTO TASK VALUES(3, 'API REST de dados','Criar a API para endpoints da aplicação', 150);



CREATE TABLE t_user (
    id int PRIMARY KEY auto_increment,
    name varchar(200),
    email varchar(200),
    password varchar(200)
);

INSERT INTO t_user VALUES(1, 'Gustavo','gustavo@fiap.com', '123');
INSERT INTO t_user VALUES(2, 'Henrique','henrique@fiap.com', '123');
INSERT INTO t_user VALUES(3, 'Vinicius','vinicius@fiap.com', '123');