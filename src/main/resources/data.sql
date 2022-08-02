INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
values (1, 'ivan.ivanov@gmail.com', 'Ivan', 'Ivanov', null, 1, '57e7759fd2d59275fc3c3cd5dd2ace5013b39ee972999412f3f5f5c3382b6765c2571ef86648abe2');

INSERT INTO brands (id, name)
VALUES
    (1, 'Apple'),
    (2, 'Samsung');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES
    (1, 'MacBook', 'LAPTOP', 2000, null, 1, 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153'),
    (2, 'Galaxy Book', 'LAPTOP', 2001, null, 2, 'https://s13emagst.akamaized.net/products/474/473596/images/res_372e1706d0eb64fd0ef9ed622c9e0394.jpg');

INSERT INTO offers (id, state, image_url, years_used, price, description, status, year, model_id, seller_id)
VALUES
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6a', 'NEW', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0, 3000, 'The newest Apple product on the market', 'AVAILABLE', 2000, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6b', 'USED', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 1, 1000, 'Samsungs best product available now', 'AVAILABLE', 2001, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6c', 'NEW', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0, 2500, 'Apple did it again with the amazing design', 'ABSENT', 2002, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6d', 'USED', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 3, 550, 'Apples first ever MacBook', 'AVAILABLE', 2000, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6e', 'NEW', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0, 2465, 'Samsung with the brand new laptop on the market', 'AVAILABLE', 2004, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6f', 'USED', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0.5, 1800, 'The newest Apple product on the market', 'ABSENT', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f61', 'NEW', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0, 3700, 'The newest Apple product on the market', 'AVAILABLE', 2006, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f62', 'NEW', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0, 2399, 'The newest Apple product on the market', 'AVAILABLE', 2007, 1, 1);