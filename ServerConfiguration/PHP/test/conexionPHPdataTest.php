<?php

	/*
	 *	Class para testeo
	 */
	require_once("../src/conexionPHPdata");

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{	
		public function testValidResult(){
			#$calc = new src\conexionPHPdata;
			$calc = new conexionPHPdata();
			$this->assertEquals(5,$calc->add(3,2));
			$this->assertEquals(true,$calc->PutData("NombreTest", "TextoTest", "GET"));
			#$this->assertEquals(true,$calc->GetData());
		} 
	}

?>
