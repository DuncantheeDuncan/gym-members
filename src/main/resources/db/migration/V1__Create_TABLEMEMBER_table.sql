CREATE TABLE TABLEMEMBER(
            MEMBERID serial not null PRIMARY KEY,
            NAME_ VARCHAR(25),
            SURNAME VARCHAR(25),
            ID_ BIGINT,
            CONTACT BIGINT,
            DATEOFBIRTH integer,
            DATEJOINED DATE NOT NULL DEFAULT CURRENT_DATE,
            MEMEMBERTYPE VARCHAR(15)

 );


 -- CREATE TABLE TABLEPAYMENT(
 --            PAYMENTID serial not null PRIMARY KEY,
 --            AMOUNT integer,
 --            PAYMENTDATE integer,
 --            foreign key (PAYMENTID) references TABLEMEMBER(MEMBERID)

 -- );

