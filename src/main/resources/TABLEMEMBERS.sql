

 create table TABLEMEMBER(
            MEMBERID serial not null primary key,
            NAME_ varchar(25),
            SURNAME varchar(25),
            ID_ bigint,
            CONTACT bigint,
            DATEOFBIRTH integer,
            AGE integer,
            DATEJOINED date not null default current_date,
            MEMEMBERTYPE varchar(15)

 );


 create table TABLEPAYMENT(
            PAYMENTID serial not null primary key,
            AMOUNT integer,
            PAYMENTDATE integer,
            foreign key (PAYMENTID) references TABLEMEMBER(MEMBERID)

 );
