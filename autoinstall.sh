echo "¿Utilizas un sistema operativo de x86?;

if (uname -i == "x86_64")
	then wget https://dl.google.com/android/adt/adt-bundle-linux-x86_64-20140702.zip;
else
	wget https://dl.google.com/android/adt/adt-bundle-linux-x86-20140702.zip;
fi
