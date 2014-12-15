<?php

  $nombre=$_REQUEST["nombre"];

  $texto=$_REQUEST["texto"];

  $modo = $_REQUEST["modo"];

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

?>

