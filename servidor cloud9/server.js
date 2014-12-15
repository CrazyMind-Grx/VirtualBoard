var net = require('net');
console.log('Servidor Iniciado.');
 
 
net.createServer(function (socket) {
    console.log("Nueva conexion");
    socket.on('data', function (data) { 
                console.log(data.toString("utf-8"));   
                socket.write("97");
    });
    socket.on('disconnect', function(){
        console.log('Se ha desconectado un cliente.');
    });
}).listen(process.env.PORT,process.env.IP);