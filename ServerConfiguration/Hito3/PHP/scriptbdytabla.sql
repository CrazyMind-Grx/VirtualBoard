
/**
* Creación de la base de datos virtualboardphp.
*
* .
*/

create database virtualboardphp;


/**
* Creación de la tabla personas en la base de datos virtualboardphp que va contener una identidad
* que es clave primaria de la tabla, y un nombre, un texto y un modo.
* .
*/

CREATE TABLE personas (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(20) NOT NULL,
 texto VARCHAR(500) NOT NULL,
 modo VARCHAR(20) NOT NULL
);


