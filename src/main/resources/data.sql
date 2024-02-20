-- data.sql
INSERT INTO t_people (full_name, pin) VALUES
                                          ('John Doe', '1234567890'),
                                          ('Jane Smith', '9876543210'),
                                          ('Alice Johnson', '4567890123'),
                                          ('Bob Anderson', '2345678901'),
                                          ('Eva Brown', '8765432109'),
                                          ('Charlie Davis', '3456789012'),
                                          ('Grace White', '7654321098'),
                                          ('David Miller', '2109876543'),
                                          ('Sophia Lee', '8901234567'),
                                          ('Oliver Wilson', '0123456789');

INSERT INTO t_addresses ( addr_type, addr_info , people_id) VALUES
                                                                    ( 'Home', '123 Main St' , 1) ,
                                                                    ( 'Work', '456 Business Rd' , 2),
                                                                    ( 'Home', '789 Residential Ave' , 3),
                                                                    ( 'Work', '890 Office Lane' , 4),
                                                                    ( 'Home', '567 Housing Blvd' , 5),
                                                                    ( 'Work', '432 Corporate Dr' , 6),
                                                                    ( 'Home', '876 Homestead Street' , 7),
                                                                    ( 'Work', '345 Business Center' , 8),
                                                                    ( 'Home', '234 Residency Lane' , 9),
                                                                    ( 'Work', '789 Office Park' , 10);

INSERT INTO t_mails ( email, email_type , people_id ) VALUES
                                                       ( 'john@example.com', 'Personal' , 1),
                                                       ( 'jane@example.com', 'Work' , 2),
                                                       ( 'alice@example.com', 'Personal' , 3),
                                                       ( 'bob@example.com', 'Work' , 4),
                                                       ( 'eva@example.com', 'Personal' , 5),
                                                       ( 'charlie@example.com', 'Work' , 6),
                                                       ( 'grace@example.com', 'Personal' , 7),
                                                       ( 'david@example.com', 'Work' , 8),
                                                       ( 'sophia@example.com', 'Personal' , 9),
                                                       ( 'oliver@example.com', 'Work' , 10);
