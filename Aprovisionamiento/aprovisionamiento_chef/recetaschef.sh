#!/bin/bash

mkdir -p chef/cookbooks/apache2/recipes
mkdir -p chef/cookbooks/mysql/recipes
mkdir -p chef/cookbooks/php/recipes
mkdir -p chef/cookbooks/git/recipes

echo package \'apache2\' > chef/cookbooks/apache2/recipes/default.rb
echo package \'python-mysqldb\' » chef/cookbooks/mysql/recipes/default.rb
echo package \'mysql-server\' » chef/cookbooks/mysql/recipes/default.rb
echo package \'mysql-client\' » chef/cookbooks/mysql/recipes/default.rb
echo package \'phpmyadmin\' > chef/cookbooks/php/recipes/default.rb
echo package \'php-mysql\' » chef/cookbooks/php/recipes/default.rb
echo package \'php5\' » chef/cookbooks/php/recipes/default.rb
echo package \'git\' > chef/cookbooks/git/recipes/default.rb

echo "{
  \"run_list\": [
                \"recipe[apache2]\",
                \"recipe[mysql]\",
                \"recipe[php]\" ,
		\"recipe[git]\"
    ] 
}" > chef/node.json

echo file_cache_path \"/chef\" > chef/solo.rb
echo cookbook_path \"/chef/cookbooks\" >> chef/solo.rb
echo json_attribs \"/chef/node.json\" >> chef/solo.rb


