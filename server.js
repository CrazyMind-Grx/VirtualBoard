var os=require('os');
var net=require('net');

var networkInterfaces=os.networkInterfaces();

var port = 8080;
var count = 1;

function servidor(socket){
    var remoteAddress = socket.remoteAddress;
    var remotePort = socket.remotePort;
    socket.setNoDelay(true);
    console.log("connected: ", remoteAddress, " : ", remotePort);
    
    var msg = 'conexión ' + remoteAddress + ' : ' +  remotePort + '\r\n'
        + "eres la conexión #" + count + '\r\n';
    count++;

    socket.end(msg);
    
    socket.on('data', function (data) {
        console.log(data.toString());
    });
    
    socket.on('end', function () {
        console.log("entrada de: ", remoteAddress, " : ", remotePort);
    });
}

console.log("Servidor en espera:");
for (var interface in networkInterfaces) {

    networkInterfaces[interface].forEach(function(details){
        
        if ((details.family=='IPv4') && !details.internal) {
            console.log(interface, details.address);  
        }
    });
}

console.log("puerto: ", port);
var netServer = net.createServer(servidor);
netServer.listen(port);