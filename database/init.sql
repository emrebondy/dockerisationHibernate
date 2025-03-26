CREATE TABLE IF NOT EXISTS annonce (
    id SERIAL PRIMARY KEY,  
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    adress VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    date TIMESTAMP NOT NULL
);

INSERT INTO annonce (title, description, adress, mail, date) 
VALUES 
    ('Annonce 91', 'Description de lannonce 1', '123 Rue Exemple, Paris', 'contact1@example.com', '2025-03-19 10:00:00'),
    ('Annonce 2', 'Description de lannonce 2', '456 Avenue Test, Lyon', 'contact2@example.com', '2025-03-20 12:30:00'),
    ('Annonce 3', 'Description de lannonce 3', '789 Boulevard Exemple, Marseille', 'contact3@example.com', '2025-03-21 09:45:00'),
    ('Annonce 4', 'Description de lannonce 4', '101 Rue Alpha, Lille', 'contact4@example.com', '2025-03-22 15:00:00'),
    ('Annonce 5', 'Description de lannonce 5', '202 Avenue Bravo, Bordeaux', 'contact5@example.com', '2025-03-23 11:20:00');

