<?php

/**
	 *  @brief Class que permite la conexion entre App y servidor.
	 *  
	 *  
	 */
class conexionPHPdata
{

	private $pdo;

	public function __construct()
    {
	
		//$dsn = "mysql:host=127.5.40.130:3306;dbname=virtualboardphp"; 
		//$usuario= "adminC77ifqE";
		//$password= "*********";
		
		try { 
			$conexion = new PDO( $GLOBALS['db_dsn'], $GLOBALS['db_username'], $GLOBALS['db_password'] ); 
			$conexion­>setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION ); 
		} catch ( PDOException $e ) { echo "Conexión fallida: " . $e­>getMessage();  }
		
		$this->$pdo = $conexion; 
    }
	
	/**
	 *  @brief Envia datos a la app y los busca en la base de datos.
	 *  
	 *  @return string  Devuelve los datos que hay en la base de datos.
	 */
	public function GetData()
	{
		
		$conexion = false;
	
		$datos = array();

		foreach($this->$pdo->query('select id, nombre, texto, modo from personas') as $row) {
			$datos[] = $row;
		}
		
		if($this->$pdo)
		{
			$conexion = true;
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
			$rows = $this->$pdo->exec("insert into personas(nombre, texto, modo) values('$nombre','$texto', '$modo')");
			
			if($rows)
				return true;
			else return false;

			return true;
			
		}else{
			return false;
		}
	
	}

}


?>