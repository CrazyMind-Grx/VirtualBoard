### Integración Continua de la APP:

Para realizar la integración continua de nuestra aplicación Android hemos estado probando con jenkins, ya que entre otras cosa nos permite realizar los test cuando por ejemplo hay alguna modificación en el repositorio (aunque no es recomendable ya que se puede sobrecargar demasiado el servidor si se estan trabajando muchos al mismo tiempo), Si se pasan los test se compilara denuevo nuestra aplicación, con lo que siempre se tiene actualizada.

Otra de las ventajas es poder seleccionar también ramas de dentro del proyecto (por lo que se pueden desarrollar en paralelo las distitnas versiones) y que está disponible para cualquier sistema operativo practicamente.

Ahora vamos a explicar como lo hemos realizado:

###### 1) Instalación
 Descargarse jenkins, desde la página oficial -> [Descargar](http://mirrors.clinkerhq.com/jenkins/debian/jenkins_1.598_all.deb) e instalarlo.
Aunque si se esta usando ubuntu (como en nuestro caso), abrid una terminal y ejecutar los siguientes comandos:

- `wget -q -O - https://jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -`	 
	
- `sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian binary/ > /etc/apt/sources.list.d/jenkins.list'`

- `sudo apt-get update`
	
- `sudo apt-get install jenkins`
	
No nos ocupará mucho espacio, unos 68MB (como se puede observar en la captura) y merece la pena por las comodidades que nos va a dar:

![](imagenes/00.png)

Una vez lo tenemos instalado, podremos ya acceder a jenkins mediante un navegador introduciendo la dirección [http://localhost:8080](http://localhost:8080), como podemos observar a continuación (señalado con un cuadro rosa):

![](imagenes/01.png)

En la captura, podemos observar que hemos señalado varias opciones (las más importantes) que vamos a explicar que función tienen:

 - Cuadro Amarillo: Lo más importante antes de crear ninguna tarea, dentro de el tendremos que configurar jenkins si queremos usar algunos plugins (como en nuestro caso, para usar Git y jUnit entre otros), también aquí podremos configurar algunos path, y ver los log de las ejecuciones de nuestras tareas, entre otras cosas.

 - Cuadro Morado: Si pinchamos sobre él creare una nueva tarea para que se realice según una serie de condiciones (que puede ser debido a un cambio en el repositorio o elegiendo unas horas para que se lleve a cabo, aunque esto lo explicaremos más detalladamente más adelante).
 
 - Cuadro Verde: Nos mostrará las estadísticas de las veces que se ha contruido la app mediante una gráfica. 
 
 - Cuadro Azul: Nos mastrara las teareas que se estan ejecutando o preparandose para ello.

