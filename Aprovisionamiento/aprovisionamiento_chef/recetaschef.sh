#!/bin/bash

mkdir -p chef/cookbooks/apache2/recipes
mkdir -p chef/cookbooks/mysql/recipes
mkdir -p chef/cookbooks/php/recipes
mkdir -p chef/cookbooks/git/recipes

echo package \'apache2\' >  chef/cookbooks/apache2/recipes/default.rb
echo package \'mysql\' >  chef/cookbooks/mysql/recipes/default.rb
echo package \'php\' >  chef/cookbooks/php/recipes/default.rb
echo package \'git\' >  chef/cookbooks/git/recipes/default.rb

