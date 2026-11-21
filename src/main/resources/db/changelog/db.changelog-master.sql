--liquibase formatted sql

--changeset derly:1
CREATE TABLE planes_turisticos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL,
    municipio VARCHAR(100) NOT NULL,
    precio_base DECIMAL(10, 2) NOT NULL,
    duracion VARCHAR(50) NOT NULL,
    tipo_turismo VARCHAR(50) NOT NULL,
    id_agencia BIGINT NOT NULL
);

CREATE TABLE reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plan_id BIGINT NOT NULL,
    nombre_turista VARCHAR(100) NOT NULL,
    documento_turista VARCHAR(30) NOT NULL,
    correo_turista VARCHAR(100) NOT NULL,
    cantidad_personas INT NOT NULL,
    estado VARCHAR(30) NOT NULL DEFAULT 'PENDIENTE',
    acepto_terminos_at DATETIME NOT NULL,
    CONSTRAINT fk_reserva_plan FOREIGN KEY (plan_id) REFERENCES planes_turisticos(id)
);

