<?php

	require_once('./conexionPHPdata.php');


	/*
	 *	Class para testeo
	 */

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{
		/*
		 *	@brief Testea conexion con BD
		 */
		public function test_conexionEstablecida()
		{
			
			$a = new conexionPHPdataTest();
		
			$this->assertTrue($a->GetData() !== false);
		
		}
		/*
 		 * @brief Testea la inserccion de elementos en la BD
 		 */
		public function text_insercionCorrecta()
		{
		
			$a = new conexionPHPdataTest();
			
			$this->assertTrue($a->PutData("Test","Texto de prueba","GET") !== false);
		
		}
		
	}

?>