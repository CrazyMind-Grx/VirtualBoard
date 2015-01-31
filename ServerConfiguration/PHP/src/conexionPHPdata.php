<?php
namespace src;
/**
	 *  @brief Class que permite la conexion entre App y servidor.
	 *  
	 *  
	 */
class conexionPHPdata
{

	public function add($x,$y)
	{
		return $x + $y;
	}

	public function PutData($nombre,$texto,$modo)
	{
		$result = "1";
		if ($nombre!="" || $texto!=""){
			/*
			$con = mysql_connect("mysql.hostinger.es","u316831537_user","colacao") or die("Sin conexion");
			mysql_select_db("u316831537_divad");
			$sql="insert into virtualboard(nombre, texto, modo) values('$nombre','$texto', '$modo')";
			$result=mysql_query($sql,$con);
			*/
			if($result == "1") return true;
			else return false;
			

		}else{
			//echo "-1";
			return false;
		}

	}

}

?>
