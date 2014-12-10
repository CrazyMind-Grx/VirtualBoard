echo "\n \n \n ............................................................................................................................\n Este script automatiza la descarga e isntalacion del entorno Eclipse + SDK manager de Android o el nuevo Android Studio 1.0 \n ............................................................................................................................ \n \n \n";

echo "¿Cual de ellos prefieres, Android Studio 1.0 (escribe una a) o Eclipse + SDK manager de Android (escribe una e) \n ";
read var1;

if [ $var1 = a ]; then
	echo "Vas a descargar Android Studio 1.0 \n \n \n";
fi;
	
if [ $var1 = e ];then
	echo "Vas a descargar Eclipse + SDK manager de Android \n \n \n";
fi;

if [ "$var1" != "a" ];then
	if [ $var1 != "e" ];then
		echo "Error al elegir la opcion, vuelva a ejecutar el programa";
		exit;
	fi;
fi;


echo "¿Quiere descargarlo en el directorio actual? (si elige no, se descargara en su directorio /home) [s o n]: \n \n \n ";
read var2;

if [ $var2 = s ]; then
	directorio=$(pwd);
	cd $directorio;
else
	cd ~;
fi;


identificarSO=`uname -i`;
echo "La arquitectura de tu sistema operativo es de: "$identificarSO " \n \n \n \n";

if [ $var1 = e ];then
	if [ $identificarSO = 'x86_64' ]; then
		wget https://dl.google.com/android/adt/adt-bundle-linux-x86_64-20140702.zip
		echo "Entra"
	else
		wget https://dl.google.com/android/adt/adt-bundle-linux-x86-20140702.zip
		echo "No entra"
	fi;
	
	unzip adt-bundle-linux-x86*.zip;
	rm adt-bundle-linux-x86*.zip;
fi;
if [ $var1=a ];then
	wget https://dl.google.com/dl/android/studio/ide-zips/1.0.0/android-studio-ide-135.1629389-linux.zip
	unzip android-studio-ide-135.1629389-linux.zip;
	rm android-studio-ide-135.1629389-linux.zip;
	sh studio.sh;
fi;	
