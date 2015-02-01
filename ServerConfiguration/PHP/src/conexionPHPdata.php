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

	public function creaTabla(){
		$con=mysqli_connect("127.0.0.1","shippable","","virtualboardphp");
		$q="CREATE TABLE personas (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
			nombre VARCHAR(20) NOT NULL,texto VARCHAR(500) NOT NULL,modo VARCHAR(20) NOT NULL);";
		mysqli_query($con, $q);
	}


	public function PutData($nombre,$texto,$modo)
	{
		if ($nombre!="" || $texto!=""){
			

			$con=mysqli_connect("127.0.0.1","shippable","","virtualboardphp");
			$q="insert into personas(nombre, texto, modo) values('$nombre','$texto', '$modo')";
			if(mysqli_query($con, $q))
			{
				return true;
			}
			else
			{
				return false;
			}


		}
		
		return false;
	}
	
	public function GetData()
 	{
		
 		$conexion = false;
 	
		$con = mysqli_connect("127.0.0.1","shippable","","virtualboardphp") or die("Sin conexion");
		//mysql_select_db("u316831537_divad");
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
