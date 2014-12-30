var express = require('express'),
    app = express(),
    server = require('http').createServer(app),
    io = require('socket.io').listen(server);
//server.listen(process.env.OPENSHIFT_NODEJS_PORT , process.env.OPENSHIFT_NODEJS_IP);
//server.listen(3000);
server.listen(process.env.PORT , process.env.IP);
console.log(process.env.PORT);
console.log(process.env.IP);
app.get('/',function(req, res){
  res.sendfile(__dirname + '/index.html');

});

io.sockets.on('connection', function(socket){
  console.log('Conectado');

  socket.on('sendMessage', function(data){
      //socket.broadcast.emit('mensaje servidor', {msg:data});
      io.sockets.emit('new message',data)
      console.log('Mensaje recibido');
      console.log(data);
  });
  socket.on('disconnect', function(){
    console.log('user disconnected');
  });

});
