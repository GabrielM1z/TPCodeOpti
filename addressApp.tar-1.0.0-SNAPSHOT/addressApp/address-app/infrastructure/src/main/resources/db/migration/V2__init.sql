-- Table Restaurant
CREATE TABLE IF NOT EXISTS Restorant (
    uuid UUID PRIMARY KEY,
    name VARCHAR(255),
    rate FLOAT,
    category VARCHAR(255)
    );

-- Table People
CREATE TABLE IF NOT EXISTS People (
    uuid UUID PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    age INT
    );

-- Table Meal
CREATE TABLE IF NOT EXISTS Meal (
    uuid UUID PRIMARY KEY,
    heure FLOAT,
    people_uuid UUID,
    restaurant_uuid UUID,
    FOREIGN KEY (restaurant_uuid) REFERENCES Restorant(uuid),
    FOREIGN KEY (people_uuid) REFERENCES People(uuid)
);
