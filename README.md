VirtualBoard
============

La idea general es que pueda haber una reunión en la que varias personas trabajan con sus tablets o móviles sobre una pantalla compartida de forma sincronizada y con la misma experiencia de usuario que si estuviesen trabajando sobre papel.

Este podría dividirse en tres grandes puntos:

####1- Funcionalidades de pizarra:

La idea es crear una pantalla donde se pueda escribir o pintar. La escritura se haría con el teclado del dispositivo. A la hora de pintar hay que conseguir una experiencia de usuario lo más realista posible, eso implica:

A- Que los trazos sean lo más fluido posible.
B- Que el grosor del trazo sea sensible a la presión. 
C- Que el grosor del trazo sea sensible a la velocidad de este.
D- Que el feedback de la pantalla sea lo más rápido posible, es decir, que no haya lag entre el momento en que se pinta y el momento en que el trazo aparece en la pantalla.

Hay un artículo en este blog sobre el tema que muestra claramente las diferencias entre la forma de dibujo "normal" y la que sería la ideal para conseguir una experiencia realista en el dibujado:
http://corner.squareup.com/2012/07/smoother-signatures.html

####2- Almacenaje/Sincronización de trazos

La idea es poder almacenar y comunicar los trazos que se hagan en el canvas. Para ello creemos que la mejor opción es convertir los diferentes trazos a SVG. El que los trazos sean vectoriales es importante ya que cada dispositivo puede tener una resolución de pantalla diferente.

Por un lado habría que almacenar toda la información de trazos en un servidor y por otro ver la mejor forma de mantener sincronizados los dispositivos entre si para que todos muestren los contenidos que se vayan dibujando.

####3- Proyección en pantalla wifi.

Con pantalla wifi nos referimos a un dispositivo con soporte airplay, chromecast o miracast.  

La idea es que, al igual que se ven los contenidos en los diferentes dispositivos, además se vean en una pantalla principal como puede ser una TV o un proyector
