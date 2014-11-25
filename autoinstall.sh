echo "\n \n \n ..............................................................................................\n Este script automatiza la descarga e isntalacion del entorno Eclipse + SDK manager de Android \n .............................................................................................. \n \n \n";

echo "¿Quiere descargar Eclipse + SDK de Android en el directorio actual? (si elige no, se descargara en su directorio /home) [s o n]: \n \n \n ";
read var1;

if [ $var1 = s ]; then
	directorio=$(pwd);
	cd $directorio;
else
	cd ~;
fi;


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
rm adt-bundle-linux-x86*.zip;
