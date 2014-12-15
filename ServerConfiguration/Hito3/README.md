#Android + PHP
#####Este documento es la explicación a todo lo desplegado hasta el momento (para el Hito 3), y los text que hemos hecho para nuestra App de Andriod.

Para esta entrega tenemos una App Android que interactúa con un servidor de OpenShift programado en PHP. En esta versión se puede mandar un texto junto con tu nombre al servidor y podrás ver todos los mensajes de quien escriba algo. Para ello hemos utilizado dos campos (nombre y texto), un checkbox para poder elegir si quieres enviar por GET o por POST el texto (ya estamos trabajando en [futuras versiones](https://github.com/IV-2014/VirtualBoard/tree/master/AppCode/VB-Socket) que nos permitián hacerlo por socket ya que tambien podremos enviar trazos dibujados ) y dos botones, enviar, para enviar el nombre y el texto, y listado, que nos translada a un activity diferente donde podemos ver los textos ya escritos anteriormente.

Para guardar los datos hemos utilizado una base de datos con MySQL.

#####Para probar que nuestra App funciona correctamente hemos utilizados varias formas de textearlo mediante máquinas virtuales:

- Una de las formas de montar máquinas virtuales de testeo es Genymotion. éste es el [enlace](https://github.com/IV-2014/VirtualBoard/blob/master/VMtestAndroid.md) al tutorial de instalacion.

El APK de la App se encuentra en [aqui](https://github.com/IV-2014/VirtualBoard/tree/master/ServerConfiguration/Hito3/InstaladorVirtualBoardBeta.apk), para el que quiera instalarla y probarla.

- Otra de las formas de testear es usando Testdroid, en el siguiente [enlace](https://github.com/IV-2014/VirtualBoard/blob/master/Testdroid.md) hay un tutorial de como lo he realizado.

- Otra forma de testear es usando AppThwack, en el siguiente [enlace](https://github.com/IV-2014/VirtualBoard/blob/master/testAppThwack.md) se muestra como lo hemos realizado.