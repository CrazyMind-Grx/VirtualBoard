#Android + PHP
#####Este documento es la explicacion a todo lo desplegado hasta el momento (para el Hito 3), y los text que hemos hecho para nuestra App de Andriod.

Para esta entraga tenemos una App Android que interactua con un servidor de OpenShift programado en PHP. En esta version se puede mandar un texto junto con tu nombre al servidor y podras ver todos los mensajes de quien escriba algo. Para ello hemos utilizado dos campos (nombre y texto), un chckbox para poder elegir si quieres enviar por GET o pos POST el texto (ya estamos trabajando en [futuras versiones](https://github.com/IV-2014/VirtualBoard/tree/master/AppCode/VB-Socket) que nos permitiran hacerlo por soket ya que tambien podremos enviar trazos dibujados ) y dos botones, enviar, para enviar el nombre y el texto, y listado, que nos translada a un activity diferete donde podemos ver los textos ya escritos anteriormente.

Para guardar los datos hemos utilizado una base de datos con MySQL.

#####Para probar que nuestra App funciona correctamente hemos utilizados varias formas de textearlo mediante maquinas virtuales:

Una de las formas de montar maquinas virtuales de testeo es Genymotion. Este es el [enlace](https://github.com/IV-2014/VirtualBoard/blob/master/VMtestAndroid.md) al tutrorial de instalacion.

El APK de la App se encuentra en [aqui](https://github.com/IV-2014/VirtualBoard/tree/master/ServerConfiguration/Hito3/InstaladorVirtualBoardBeta.apk), para el que quiera instalarla y probarla.