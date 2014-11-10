#Documentación Despliegue

VirtualBoard requerirá el uso de un servidor para realizar la comunicación entre los dispositivos que estén trabajando con la aplicación.
#### 


---

## Openshift

### ¿Que es Openshift?

**OpenShift** es un producto de computación en la nube de plataforma como servicio de **Red Hat**.

Este software funciona como un servicio que es de código abierto bajo el nombre de "OpenShift Origin", y está disponible en GitHub.

Los desarrolladores pueden usar Git para desplegar sus aplicaciones Web en los diferentes lenguajes de la plataforma.

OpenShift también soporta programas binarios que sean aplicaciones Web, con tal de que se puedan ejecutar en RHEL Linux. Esto permite el uso de lenguajes arbitrarios y frameworks.

OpenShift se encarga de mantener los servicios subyacentes a la aplicación y la escalabilidad de la aplicación como se necesite.

### ¿Por qué usar Openshift?

- Ventajas
	- Acelera el desarrollo y la entrega: permitiendo que los desarrolladores se centren en lo que más les importa (el código) para agilizar el proceso de desarrollo. Automatice los procesos de TI para facilitar la entrega de servicios de TI.

	- Ofrece a los desarrolladores libertad de elección: Permíten utilizar interfaces, lenguajes, frameworks, servicios, nubes, elasticidad e infraestructura que ya conocen y prefieren.

	- Utilizar su infraestructura de manera más eficiente: En los entornos de desarrollo, de prueba y de producción.

	- Ofrece diversos modelos de interacción: Estos permiten a los desarrolladores utilizar una gran variedad de herramientas de línea de comando, una potente consola web multidispositivo o un entorno de desarrollo integrado (IDE) basado en Eclipse como Red Hat JBoss® Developer Studio.

######OpenShift está disponible en dos modelos de consumo diferentes, nosotros nos vamos a regir por el público.

- PaaS Pública
	- Permite que las aplicaciones se escalen de forma automática en un entorno de nube flexible.

	- Menor tiempo de comercialización.

 	- Inscripción gratuita: disponible para que los desarrolladores puedan consultar las extraordinarias características y prestaciones, así como empezar a codificar y ejecutar aplicaciones en OpenShift.


- Elegimos openShift debido a las siguientes características:
	- Un buen plan gratuito.
	- Código abierto.
	- Bien documentado.
	- Apoyo Node.js
	- Dominios personalizados.
	- Arquitectura limpia y simple.
	- Entornos personalizables.
	- Apoyo MongoDB.
	- Apoyo PHP.
	- Más fluido en streaming

### El servidor de VirtualBoard

El servidor de VirtualBoard está corriendo 24/7 y para comprobar su estado podemos acceder a una web que está sirviendo continuamente [ver web](http://nodejs-virtualboard.rhcloud.com/)