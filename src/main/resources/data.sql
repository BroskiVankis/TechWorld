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
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6a', 'NEW', 'https://www.apple.com/v/macbook-pro-13/m/images/meta/macbook-pro-13_overview__bcsyunk73i2a_og.jpg?202206270153', 0, 3000, 'The newest Apple product on the market', 'AVAILABLE', 2000, 1, 1);