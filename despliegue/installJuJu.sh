if [[ $EUID -ne 0 ]]; then
echo "Debes ser root para ejecutar este script"
else
	add-apt-repository ppa:juju/stable
	apt-get update
	apt-get install juju-core
	
	
fi
