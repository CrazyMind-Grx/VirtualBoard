### Integración Continua de la APP:

Para realizar la integración continua de nuestra aplicación Android hemos estado probando con jenkins, ya que entre otras cosa nos permite realizar los test cuando por ejemplo hay alguna modificación en el repositorio (aunque no es recomendable ya que se puede sobrecargar demasiado el servidor si se estan trabajando muchos al mismo tiempo), Si se pasan los test se compilara denuevo nuestra aplicación, con lo que siempre se tiene actualizada.

Otra de las ventajas es poder seleccionar también ramas de dentro del proyecto (por lo que se pueden desarrollar en paralelo las distitnas versiones) y que está disponible para cualquier sistema operativo practicamente.

Ahora vamos a explicar como lo hemos realizado:

1. Descargarse jenkins, desde la página oficial -> [Descargar](http://mirrors.clinkerhq.com/jenkins/debian/jenkins_1.598_all.deb) e instalarlo.
Aunque si se esta usando ubuntu (como en nuestro caso), abrid una terminal y ejecutar los siguientes comandos:

	- `wget -q -O - https://jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -`	 
	
	- `sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian binary/ > /etc/apt/sources.list.d/jenkins.list'`

	- `sudo apt-get update`
	
	- `sudo apt-get install jenkins`