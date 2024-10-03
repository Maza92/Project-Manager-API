CREATE TABLE IF NOT EXISTS user_role (
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

INSERT INTO user_role (role_name) VALUES ('ADMIN');
INSERT INTO user_role (role_name) VALUES ('USER');
INSERT INTO user_role (role_name) VALUES ('GUEST');

INSERT INTO technology (name) VALUES 
('Java'),
('Spring Boot'),
('React'),
('Angular'),
('Python'),
('Node.js'),
('Docker'),
('Kubernetes'),
('AWS'),
('MySQL');

INSERT INTO course (title, description, price, video_preview_url, teacher_name, level, category, duration_hours, total_lessons, average_rating, is_published, created_at, updated_at) VALUES
('Curso Completo de Java', 'Aprende Java desde cero hasta nivel avanzado con ejercicios prácticos', 99.99, 'https://example.com/preview/java', 'Carlos Rodríguez', 'BEGINNER', 'Programación', 40, 120, 4.7, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Spring Boot Master', 'Desarrollo de aplicaciones empresariales con Spring Boot', 149.99, 'https://example.com/preview/spring', 'Ana Martínez', 'INTERMEDIATE', 'Frameworks', 35, 90, 4.8, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('React para Principiantes', 'Domina React y crea aplicaciones web modernas', 79.99, 'https://example.com/preview/react', 'Luis García', 'BEGINNER', 'Frontend', 25, 80, 4.5, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('DevOps Fundamentals', 'Introducción a DevOps con Docker y Kubernetes', 199.99, 'https://example.com/preview/devops', 'María Sánchez', 'ADVANCED', 'DevOps', 50, 150, 4.9, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Python para Data Science', 'Análisis de datos y machine learning con Python', 129.99, 'https://example.com/preview/python', 'Jorge Pérez', 'INTERMEDIATE', 'Data Science', 45, 130, 4.6, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO lesson (title, description, video_url, duration_minutes, course_id, created_at, updated_at) VALUES
('Introducción a Java', 'Conceptos básicos de Java y configuración del entorno', 'https://example.com/java/lesson1', 45, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Variables y Tipos de Datos', 'Aprende sobre los diferentes tipos de datos en Java', 'https://example.com/java/lesson2', 50, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Estructuras de Control', 'Condicionales y bucles en Java', 'https://example.com/java/lesson3', 55, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('Introducción a Spring Boot', 'Fundamentos de Spring Boot y su ecosistema', 'https://example.com/spring/lesson1', 40, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('REST APIs con Spring', 'Desarrollo de APIs RESTful', 'https://example.com/spring/lesson2', 60, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Spring Data JPA', 'Persistencia de datos con Spring Data JPA', 'https://example.com/spring/lesson3', 55, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO course_technology (course_id, technology_id) VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 3),
(4, 7),
(4, 8),
(5, 5);
