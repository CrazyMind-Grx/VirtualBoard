cd ~;
echo "\n \n \n ........................................................................\n Descargando e instalando el entorno de desarrollo para Android \n ........................................................................ \n \n \n";

identificarSO=`uname -i`;
echo "La arquitectura de tu sistema operativo es de: "$identificarSO " \n \n \n \n";

if [ $identificarSO = 'x86_64' ]; then
	wget https://dl.google.com/android/adt/adt-bundle-linux-x86_64-20140702.zip
	echo "Entra"
else
	wget https://dl.google.com/android/adt/adt-bundle-linux-x86-20140702.zip
	echo "No entra"
fi;

unzip adt-bundle-linux-x86*.zip;
