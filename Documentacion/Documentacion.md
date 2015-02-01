#VirtualBoard
---

#####Índice de contenidos
######Descripción general
- ######¿Qué es vitualboard?

######Organización del trabajo
######Tecnología utilizada
- ######Cliente
- ######Servidor

######Proyecto


---
##Descripción general

#####¿Qué es VirtualBoard?

VirtualBoard es una aplicación que permitirá que varias personas trabajen con sus tablets o móviles sobre una pantalla compartida de forma sincronizada y con la misma experiencia de usuario que si estuviesen trabajando sobre papel.

La idea general de la App VirtualBoard es que pueda haber una reunión en la que varias personas trabajen con sus tablets o móviles sobre una pantalla compartida de forma sincronizada y con la misma experiencia de usuario que si estuviesen trabajando sobre papel.

##Organización del trabajo

Tras crear el grupo de compañeros y elegir el proyecto comenzamos con la creación de un repositorio en GitHub, dentro de la organización IV/GII, organización perteneciente a la asignatura de Infraestructura Virtual.

Para coordinarnos de manera eficiente realizamos un grupo en 'Telegram' y un Board en Trello para almacenar la información sobre el proyecto, usuarios y pass, enlaces de ayuda, tutoriales de ayuda, etc.

Además hemos creado una cuenta de correo electrónico para que los interesados puedan contactar con nosotros: virtualboard.iv@gmail.com.

También disponemos de cuenta en la red social Twitter: https://twitter.com/VirtualBoard1

Para trabajar usamos la metodología de trabajo colaborativa usando git y sus issues. De esta forma creamos un Issue por tarea principal a desarrollar o mejora referenciando en cada commit a su issue asociado. Una vez terminada una tarea se cierra el issue.

Git nos ha ayudado a trabajar en grupo teniendo la posibilidad de volver atrás en caso de realizar cambios fallidos.

##Tecnología utilizada

La aplicación actual, está compuesta por dos "partes", servidor-cliente.

Por la parte del **cliente** hemos desarrollado una app para Android con Android Studio y Eclipse, programada en Java. Podemos verla en funcionamiento aquí [aquí](https://github.com/IV-2014/VirtualBoard/blob/master/Images/testAppth01.jpg).

Por la parte del **servidor**:

- Despliegue: ha sido realizado con **[Docker](https://github.com/IV-2014/VirtualBoard/tree/master/despliegue)** que nos permite "empaquetarlo" todo y desplegarlo en cualquier sistema Linux sin necesidad más que de introducir un par de comandos

- Aprovisionamiento: ha sido realizado con **[Ansible](https://github.com/IV-2014/VirtualBoard/tree/master/Aprovisionamiento)**

- 







##Proyecto

El proyecto está dividido en tres fases:

- Funcionalidades de pizarra:

Se creará una pantalla donde se pueda escribir o pintar. La escritura se haría con el teclado del dispositivo. A la hora de pintar se hara directamente en la pantalla del dispositivo y sera lo mas real posible.


- Almacenaje/Sincronización de trazos

Se podrá almacenar y comunicar los trazos que se hagan en el canvas. Para ello convertiremos los diferentes trazos a SVG. El que los trazos sean vectoriales es importante ya que cada dispositivo puede tener una resolución de pantalla diferente.

Por un lado que almacenaremos toda la información de trazos en un servidor y por otro ver la mejor forma de mantener sincronizados los dispositivos entre si para que todos muestren los contenidos que se vayan dibujando.

- Proyección en pantalla wifi.

Con pantalla wifi nos referimos a un dispositivo con soporte airplay, chromecast o miracast.

Al igual que se ven los contenidos en los diferentes dispositivos, además se vean en una pantalla principal como puede ser una TV o un proyector.

#####Herramientas se utilizarán para implementarlo

Tendremos que programar la parte del servidor y la parte del cliente. En el servidor utilizaremos Python o Node.js para las conexiones aun está por decidir que puede ser mas interesante para nuestra aplicacion por temas de rapidez, lag y fluidez. Finalmente y tras hacer varias pruebas, vamos a utilizar [OpenShift](https://openshift.redhat.com)
En cuanto al tema del usuario utilizaremos Android, una app con una interface sencilla e intuitiva para que nuestro cliente pueda manejar su VirtualBoard.



Conoce más [aquí](https://github.com/IV-2014/VirtualBoard/blob/master/README.md)

##Documentación Despliegue

[Ver documentacion](https://github.com/IV-2014/VirtualBoard/blob/master/ServerConfiguration/DocumentacionDespliegue.md)

##Testear una aplicación android en una Máquina virtual en linux
#####En este tutorial vamos a explicar como montar tu maquina virtual Android y como conectarla a Android Studio para poder hacer pruebas previas a lanzar nuestra App.