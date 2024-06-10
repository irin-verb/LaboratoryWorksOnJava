CREATE TABLE Product(
    Id int not null,
    Price int not null,
    Unit varchar(50),
    Description varchar(200));

ALTER TABLE Product
ADD CONSTRAINT PK_ProductId primary key (Id);

CREATE TABLE Customer(
    Id int not null,
    Nomination varchar(50),
    Adress varchar(200),
    Telephone varchar(11) not null,
    Surname varchar(50));

ALTER TABLE Customer
ADD CONSTRAINT PK_CustomerId primary key (Id);

CREATE TABLE Booking(
    Id int not null,
    CustomerId int not null,
    ProductId int not null,
    Quantity int not null,
    DateValue date not null);
    
ALTER TABLE Booking
ADD CONSTRAINT PK_BookingId primary key (Id);