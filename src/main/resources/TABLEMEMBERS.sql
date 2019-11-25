

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


 CREATE TABLE TABLEPAYMENT(
            PAYMENTID serial not null PRIMARY KEY,
            AMOUNT integer,
            PAYMENTDATE integer,
            foreign key (PAYMENTID) references TABLEMEMBER(MEMBERID)

 );




-- The tblPayments table will be used to keep track of payments made by Members. PaymentID,
--Date, Amount. The tblPayments should be related to tblMembers accordingly


-- TABLEMEMBERS (MEMBERID, NAME, SURNAME, ID, CONTACT, DATEOFBIRTH,DATEJOINED,  MEMEMBERTYPE