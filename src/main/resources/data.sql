-- Crear la tabla user_role si no existe
CREATE TABLE IF NOT EXISTS user_role (
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

-- Insertar roles en la tabla user_role
INSERT INTO user_role (role_name) VALUES ('ADMIN');
INSERT INTO user_role (role_name) VALUES ('USER');
INSERT INTO user_role (role_name) VALUES ('MODERATOR');
