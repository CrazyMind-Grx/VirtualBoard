<?php

/**
	 *  @brief Class que permite la conexion entre App y servidor.
	 *  
	 *  
	 */
class conexionPHPdata
{


	/**
	 *  @brief Envia datos a la app y los busca en la base de datos.
	 *  
	 *  @return string  Devuelve los datos que hay en la base de datos.
	 */
	public function GetData()
	{
	
		$conexion = false;
	
		$con = mysql_connect("$GLOBALS['localhost']",$GLOBALS['db_username'],"$GLOBALS['db_password']") or die("Sin conexion");
		mysql_select_db("$GLOBALS['db_dsn']");
		$sql="select id, nombre, texto, modo from personas";

		$datos=array();

		if($rs=mysql_query($sql,$con))
		{
			$conexion = true;
		}

		while($row=mysql_fetch_object($rs)){
			$datos[] = $row;
		}

		echo json_encode($datos);
	
		return $conexion;
	}
	
	
	/**
	 *  @brief Mete datos en la BD que provienen de la app android
	 *  @param string $nombre Primer parametros de entrada en este caso es el nombre de usuario.
	 *  @param string $texto Segundo parametro, es el texto que introduce dicho usuario
	 *  @param string $modo Es el modo (POST/GET) que el usuario realiza la peticion.
	 *  @return string $result devuelve que se ha metido para su verificacion.
	 */
	public function PutData($nombre,$texto,$modo)
	{
	
		if ($nombre!="" || $texto!=""){
			
			//$con = mysql_connect("127.5.40.130:3306","adminC77ifqE","*********") or die("Sin conexion");
			//mysql_select_db("virtualboardphp");
			$con = mysql_connect("$GLOBALS['localhost']",$GLOBALS['db_username'],"$GLOBALS['db_password']") or die("Sin conexion");
			mysql_select_db("$GLOBALS['db_dsn']");


			echo $sql="insert into personas(nombre, texto, modo) values('$nombre','$texto', '$modo')";
			
			$result=mysql_query($sql,$con);
			
			echo $result;
			return true;
			
		}else{
		
			echo "-1";
			return false;
		}
	
	}

}


?>