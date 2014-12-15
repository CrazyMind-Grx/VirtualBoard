<?php

  $nombre=$_REQUEST["nombre"];

  $texto=$_REQUEST["texto"];

  $modo = $_REQUEST["modo"];

   if ($nombre!="" || $texto!=""){

     $con = mysql_connect("127.0.0.1","root","********") or die("Sin conexion");

         mysql_select_db("mybase");

    echo $sql="insert into personas(nombre, texto, modo) 

             values('$nombre','$texto', '$modo')";

         $result=mysql_query($sql,$con);

         echo $result;

  }else{

     echo "-1";

   }

?>

