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
			
			$con = mysql_connect("127.5.40.130:3306","adminC77ifqE","Virtualboard1") or die("Sin conexion");
			mysql_select_db("virtualboardphp");


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
