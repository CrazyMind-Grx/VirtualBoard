#!/bin/bash
cd ~/VirtualBoard/Aprovisionamiento
mysql -h localhost -u virtualboard -p virtualboard

#create database virtualboardphp; #-------modificado
use virtualboardphp;
CREATE TABLE personas (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(20) NOT NULL,
 texto VARCHAR(500) NOT NULL,
 modo VARCHAR(20) NOT NULL
);
