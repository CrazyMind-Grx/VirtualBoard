#Cómo testear tu App android en una Máquina Virtual en Linux

En este tutorial vamos a explicar cómo montar tu máquina virtual Android y cómo conectarla a Android Studio para poder hacer pruebas previas a lanzar nuestra App.

###1º Instalar VirtualBox

Para instalar virtual box, solo tendremos que ir al centro de software de nuestro linux y desde ahí descargar Virtualbox. Es lo más sencillo y rápido.

###2º Instalar Genymotion
 El primer paso es [registrarnos en Genymotion](https://www.genymotion.com/#!/auth/account-creation).
 
 Tras acceder al link que nos envían a nuestro email, lo [descargamos](https://www.genymotion.com/#!/download). Al hacer esto, se descargará un archivo .bin, le damos permiso de ejecución y lo ejecutamos [así](http://showterm.io/81fc6d57e822570542781).
 
Ahora vamos a la carpta genymotion que se ha creado y ejecutamos el archivo genymotion con:

	./genymotion
    
Nos aparecerá esta ventana, y clicamos en YES:

![ventana1](https://github.com/IV-2014/VirtualBoard/blob/master/Images/tutoVM1.png)

Nos logueamos y elegimos el tipo de dispositivo que queremos utilizar:

![ventana2](https://github.com/IV-2014/VirtualBoard/blob/master/Images/tutoVM2.png)

Una vez elegida, se descargará la imagen que queremos. Arrancamos la máquina, y ya la tenemos funcionando.

Una vez que es está arrancada, solo nos queda conectarla con nuestro Android Studio. Para esto abriremos Android Studio e iremos a:

	File > Settings
    Plugins > Browse Repositories
    Buscamons genymotion y pulsamos en Download and install 

