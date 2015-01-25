<?php

	

	/*
	 *	Class para testeo
	 */

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{	
		private $pdo;

	    public function setUp()
	    {
	        $this->pdo = new PDO($GLOBALS['db_dsn'], $GLOBALS['db_username'], $GLOBALS['db_password']);
	        $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	        $this->pdo->query("CREATE TABLE personas (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
													 nombre VARCHAR(20) NOT NULL,
													 texto VARCHAR(500) NOT NULL,
													 modo VARCHAR(20) NOT NULL)");
	    }

	    public function tearDown()
	    {
	        $this->pdo->query("DROP TABLE personas");
	    }

	    public function testPutData()
	    {
	        $data = new conexionPHPdata($this->pdo);

	        $this->assertEquals(true, $data->PutData('Nombre','Texto','Modo'));
	    }


	    public function testGetData()
	    {
	        $data = new conexionPHPdata($this->pdo);

	        $this->assertFalse($data->GetData());

	        $data->PutData('Nombre','Texto','Modo');


	        $this->assertEquals(true, $data->GetData());
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