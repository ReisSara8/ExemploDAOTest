/**
 * Author:  Alunos
 * Created: 08/10/2018
 */

DROP DATABASE IF EXISTS kleitom;
CREATE DATABASE kleitom;
use kleitom;

CREATE TABLE macarroes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(100),
    marca VARCHAR(100),
    peso DOUBLE,
    aldente BOOLEAN
);

