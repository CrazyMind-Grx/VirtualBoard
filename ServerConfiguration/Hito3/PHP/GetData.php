GetData.php                                                                                                                                        
<?php

 $con = mysql_connect("127.0.0.1","root","********") or die("Sin conexion");

  mysql_select_db("mybase"); 

  $sql="select id, nombre, texto, modo from personas";

  $datos=array();

  $rs=mysql_query($sql,$con);

  while($row=mysql_fetch_object($rs)){

       $datos[] = $row;
  }

  echo json_encode($datos);
  ?>



