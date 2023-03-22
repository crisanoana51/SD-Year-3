INSERT INTO concert (id, available_tickets, description, max_nr_tickets, name) VALUES
                                                                                   (2, 280, '7 pm, 2.5h, genre: progressive house', 280, 'Concert Afrojack'),
                                                                                   (3, 220, '9 pm, 2h, genre: house', 220, 'Concert David Guetta'),
                                                                                   (4, 280, '7 pm, 2.5h, genre: progressive house', 280, 'Concert Martin Garrix'),
                                                                                   (5, 300, '10 pm, 2.5h, genre: trance', 300, 'Concert Armin Van Buuren'),
                                                                                   (6, 250, '8 pm, 2h, genre: EDM', 250, 'Concert Calvin Harris');



INSERT INTO ticket (id, nr_places, price, concert_id) VALUES
                                                                      (1, 2, 250.00, 2),
                                                                      (2, 1, 500.00, 3),
                                                                      (3, 4, 200.00, 4),
                                                                      (4, 3, 300.00, 5),
                                                                      (5, 2, 350.00, 6);



