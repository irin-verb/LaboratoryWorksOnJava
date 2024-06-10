SELECT Booking.Id, Customer.Nomination, Product.Description, Booking.Quantity, Booking.DateValue
FROM Booking INNER JOIN Product ON Booking.ProductId = Product.Id
    INNER JOIN Customer ON Booking.CustomerId = Customer.Id
WHERE Booking.DateValue < TO_DATE(20230501,'YYYYMMDD') AND Booking.DateValue > TO_DATE(20230101,'YYYYMMDD')

SELECT Booking.CustomerId
FROM Booking
WHERE Booking.ProductId = 0

SELECT Booking.CustomerId, count(*)
FROM Booking
GROUP BY Booking.CustomerId
