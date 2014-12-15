#mini tutorial como configurar el servidor en OpenShift
# y poder utilizarlo en maquina loca


sudo apt-get install ruby-full rubygems git-core;

echo "*********************************************"
echo "Probando Ruby para su ejecucion"
ruby -e 'puts "Welcome to Ruby"'

echo "La version de git es: \n"
git --version

echo "Instalando rhc, comando para poder crear aplicaciones en OpenShift desde equipo local"

sudo gem install rhc

sudo gem install rubygems-update

sudo update_rubygems

echo "Creando la aplicacion en el servidor"
echo "Introduce el nombre de la aplicacion"
read $a
rhc app-create $a python-2.7
