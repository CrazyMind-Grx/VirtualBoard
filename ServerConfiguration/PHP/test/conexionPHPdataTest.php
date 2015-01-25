<?php

	/*
	 *	Class para testeo
	 */

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{	
		private $pdo;

	    public function __construct()
	    {
	        $this->pdo = new PDO($GLOBALS['db_dsn'], $GLOBALS['db_username'], $GLOBALS['db_password']);
	        $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	        $this->pdo->query("CREATE TABLE personas (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
													 nombre VARCHAR(20) NOT NULL,
													 texto VARCHAR(500) NOT NULL,
													 modo VARCHAR(20) NOT NULL)");
	    }



	    public function testPutData()
	    {
	        $data = new src\conexionPHPdata();

	        $this->assertTrue($data->PutData('Nombre','Texto','Modo'));
	    }


	    public function testGetData()
	    {
	        $data = new src\conexionPHPdata();

	        $this->assertFalse($data->GetData());

	        $data->PutData('Nombre','Texto','Modo');


	        $this->assertTrue($data->GetData());
	    }















		//##################################################################
		/*
		 *	@brief Testea conexion con BD
		 */
		/*public function test_conexionEstablecida()
		{
			
			$a = new conexionPHPdata();
		
			$this->assertTrue($a->GetData() !== false);
		
		}
		/*
 		 * @brief Testea la inserccion de elementos en la BD
 		 */
		/*public function text_insercionCorrecta()
		{
		
			$a = new conexionPHPdata();
			
			$this->assertTrue($a->PutData("Test","Texto de prueba","GET") !== false);
		
		}*/
		
	}

?>