
<?php


getdata();



/**
 *  @brief Funcion para enviar datos a la app y los busca en la base de datos.
 *  
 *  @return string  Devuelve los datos que hay en la base de datos.
 */
 
function getdata(){

 $con = mysql_connect("127.5.40.130:3306","adminC77ifqE","******") or die("Sin conexion");

  mysql_select_db("virtualboardphp"); 

  $sql="select id, nombre, texto, modo from personas";

  $datos=array();

  $rs=mysql_query($sql,$con);

  while($row=mysql_fetch_object($rs)){

       $datos[] = $row;
  }

  echo json_encode($datos);
}
  ?>



