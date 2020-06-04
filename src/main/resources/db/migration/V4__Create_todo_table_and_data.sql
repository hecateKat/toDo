create table todos (
    id int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit
);

insert into todos (text, done) values ('Undone to Do', 0);
insert into todos (text, done) values ('Done to Do', 1);
