CREATE TABLE "books" (
    "id"            BIGSERIAL PRIMARY KEY,
    "title"         VARCHAR NOT NULL,
    "release_date"  DATE NOT NULL,
    "category_id"   INTEGER REFERENCES categories,
    "quantity"      INTEGER,
    "author"        VARCHAR NOT NULL
);
ALTER TABLE books ADD CONSTRAINT books_unique_title UNIQUE (title);