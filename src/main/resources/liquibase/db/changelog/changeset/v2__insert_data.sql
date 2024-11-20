insert into users(name, username, password)
values('Maksim Maslov', 'maslov@gmail.com', '$2a$10$Z8EJJNP5cxGRh/8nD7.8qOl9hNqQTyWE4t5zGNX0Nf9ZXD4aMBaa.'),
      ('Oleg Kirillov', 'kirillov@mail.rus', '$2a$10$jC/7Mht/B4Y1sWTlrnSYXehSL3S51HZYrIWjhGxie6YyNuuqbxCmq');

insert into tasks(title, description, status, expiration_date)
values('Buy watermelon', null, 'TODO', '2024-05-13 12:00:00'),
      ('Eat 12000 kk', 'Need more eat', 'IN_PROGRESS', '2024-05-13 12:00:00'),
      ('Listen new track', null, 'DONE', null),
      ('Call at mom', 'ask about kitchen', 'TODO', '2024-06-25 00:00:00');

insert into users_tasks(task_id, user_id)
values(1, 2),
      (2, 2),
      (3, 2),
      (4, 1);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');
