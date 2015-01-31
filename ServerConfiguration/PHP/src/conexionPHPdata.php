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
		if ($nombre!="" || $texto!=""){
			
			$con = mysqli_connect("mysql.hostinger.es","u316831537_user","colacao") or die("Sin conexion");
			mysql_select_db("u316831537_divad");
			$sql="insert into virtualboard(nombre, texto, modo) values('$nombre','$texto', '$modo')";
			$result=mysql_query($sql,$con);
			
			if($result == "1") return true;
			else return false;
			

		}else{
			return false;
		}

	}
	
	public function GetData()
 	{
		
 		$conexion = false;
 	
		$con = mysqli_connect("mysql.hostinger.es","u316831537_user","colacao") or die("Sin conexion");
		mysql_select_db("u316831537_divad");
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
}

?>
