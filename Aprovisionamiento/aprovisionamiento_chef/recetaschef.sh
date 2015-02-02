#!/bin/bash

mkdir -p chef/cookbooks/apache2/recipes
mkdir -p chef/cookbooks/mysql/recipes
mkdir -p chef/cookbooks/php/recipes
mkdir -p chef/cookbooks/git/recipes

echo package \'apache2\' > chef/cookbooks/apache2/recipes/default.rb
echo package \'python-mysqldb\' >> chef/cookbooks/mysql/recipes/default.rb
echo package \'mysql-server\' >> chef/cookbooks/mysql/recipes/default.rb
echo package \'mysql-client\' >> chef/cookbooks/mysql/recipes/default.rb
echo package \'phpmyadmin\' > chef/cookbooks/php/recipes/default.rb
echo package \'php5\' >> chef/cookbooks/php/recipes/default.rb
echo package \'git\' > chef/cookbooks/git/recipes/default.rb

echo "{
 \"run_list\": [
 \"recipe[apache2]\",
 \"recipe[mysql]\",
 \"recipe[php]\" ,
 \"recipe[git]\"
 ] 
}" > chef/node.json

echo "maintainer       \"VirtualBoard\"
maintainer_email  \"vitualboard@gmail.com\"
description       \"Instala servidor Apache \"
version           \"0.1 \"

recipe  \"apache2 \",  \"Despliegue servidor web \" ">  chef/cookbooks/apache2/metadato.rb


echo "maintainer       \"VirtualBoard\"
maintainer_email  \"vitualboard@gmail.com\"
description       \"Instala mysql \"
version           \"0.1 \"

recipe  \"mysql \",  \"Despliegue de mysql \" ">  chef/cookbooks/mysql/metadato.rb


echo "maintainer       \"VirtualBoard\"
maintainer_email  \"vitualboard@gmail.com\"
description       \"Instala php \"
version           \"0.1 \"

recipe  \"php\",  \"Despliegue de php\" ">  chef/cookbooks/php/metadato.rb

echo "maintainer       \"VirtualBoard\"
maintainer_email  \"vitualboard@gmail.com\"
description       \"Instala git \"
version           \"0.1 \"

recipe  \"git\",  \"Despliegue de git\" ">  chef/cookbooks/git/metadato.rb


echo file_cache_path \"/chef\" > chef/solo.rb
echo cookbook_path \"/chef/cookbooks\" >> chef/solo.rb
echo json_attribs \"/chef/node.json\" >> chef/solo.rb

git clone  https://github.com/IV-2014/VirtualBoard.git

sudo apt-get install chef

sudo chef-solo -c /chef/solo.rb 

mysql -u root -e " CREATE DATABASE virtualboardphp;use virtualboardphp; CREATE TABLE personas (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(20) NOT NULL,
texto VARCHAR(500) NOT NULL,
modo VARCHAR(20) NOT NULL
);"
