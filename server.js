var os=require('os');//importamos módulo para obtener informaciones del sistema operatico que se usa
var net=require('net');//importamos módulo para conexiones de red

var networkInterfaces=os.networkInterfaces();// lo usamos para obtener las conexiones disponibles

var port = 8080;
var count = 1;

function servidor(socket){
    var remoteAddress = socket.remoteAddress;//ip del socket
    var remotePort = socket.remotePort;//puerto del socket
    socket.setNoDelay(true);// para enviar los datos inmediatamente en cuanto el socket.write() es llamado desde el cliente
    console.log("connected: ", remoteAddress, " : ", remotePort);
    //para crear un mensaje diciendole el tipo de ip y puerto y que conexión es
    var msg = 'conexión ' + remoteAddress + ' : ' +  remotePort + '\r\n'
        + "eres la conexión #" + count + '\r\n';
    count++;

    socket.end(msg);//envia el mensaje
    
    socket.on('data', function (data) {
        console.log(data.toString());// muestra los datos tras convertirlos en un string
    });
    
    socket.on('end', function () {
        console.log("desconexión de: ", remoteAddress, " : ", remotePort);// muestra la ip y puerto del cliente al desconectarse
    });
}

console.log("Servidor en espera:");
for (var interface in networkInterfaces) {
	networkInterfaces[interface].forEach(function(details){// para obtener las conexiones(ip)
		if ((details.family=='IPv4') && !details.internal) {
			console.log(interface, details.address);  
		}
	});
}

console.log("puerto: ", port);
var netServer = net.createServer(servidor);// creamos el servidor
netServer.listen(port);// lo ponemos en estado de escucha en el puerto