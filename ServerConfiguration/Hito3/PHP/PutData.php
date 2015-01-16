<?php

/**
 *  @author VirtualBoard
 *  @brief Api del Servidor para la conexion de la App
 *  
 *  
 *  
 */





putdata($_REQUEST["nombre"],$_REQUEST["texto"],$_REQUEST["modo"]);




 /**
 *  @brief Funcion para meter datos en la BD
 *  @param string $nombre Primer parametros de entrada en este caso es el nombre de usuario.
 *  @param string $texto Segundo parametro, es el texto que introduce dicho usuario
 *  @param string $modo Es el modo (POST/GET) que el usuario realiza la peticion.
 *  @return string $result devuelve que se ha metido para su verificacion.
 */
 

  function putdata($nombre,$texto,$modo){

     if ($nombre!="" || $texto!=""){

       $con = mysql_connect("127.5.40.130:3306","adminC77ifqE","*********") or die("Sin conexion");

           mysql_select_db("virtualboardphp");

      echo $sql="insert into personas(nombre, texto, modo) 

               values('$nombre','$texto', '$modo')";

           $result=mysql_query($sql,$con);

           echo $result;

    }else{

       echo "-1";

     }
  }

?>

