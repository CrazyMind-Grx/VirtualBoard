VirtualBoard
============

La idea general de la App VirtualBoard es que pueda haber una reunión en la que varias personas trabajen con sus tablets o móviles sobre una pantalla compartida de forma sincronizada y con la misma experiencia de usuario que si estuviesen trabajando sobre papel.

El proyecto está dividido en tres fases:

####1- Funcionalidades de pizarra:

Se creará una pantalla donde se pueda escribir o pintar. La escritura se haría con el teclado del dispositivo. A la hora de pintar se hara directamente en la pantalla del dispositivo y sera lo mas real posible.


####2- Almacenaje/Sincronización de trazos

Se podrá almacenar y comunicar los trazos que se hagan en el canvas. Para ello convertiremos los diferentes trazos a SVG. El que los trazos sean vectoriales es importante ya que cada dispositivo puede tener una resolución de pantalla diferente.

Por un lado que almacenaremos toda la información de trazos en un servidor y por otro ver la mejor forma de mantener sincronizados los dispositivos entre si para que todos muestren los contenidos que se vayan dibujando.  

####3- Proyección en pantalla wifi.

Con pantalla wifi nos referimos a un dispositivo con soporte airplay, chromecast o miracast.  

Al igual que se ven los contenidos en los diferentes dispositivos, además se vean en una pantalla principal como puede ser una TV o un proyector

####Herramientas se utilizarán para implementarlo

Tendremos que programar la parte del servidor y la parte del cliente. En el servidor utilizaremos Python o Node.js para las conexiones aun está por decidir que puede ser mas interesante para nuestra aplicacion por temas de rapidez, lag y fluidez. Finalmente y tras hacer varias pruebas, vamos a utilizar [OpenShift](https://openshift.redhat.com)
En cuanto al tema del usuario utilizaremos Android, una app con una interface sencilla e intuitiva para que nuestro cliente pueda manejar su VirtualBoard.


