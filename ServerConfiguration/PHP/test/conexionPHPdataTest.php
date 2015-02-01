<?php

	/*
	 *	Class para testeo
	 */

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{	
		public function testValidResult(){
			$calc = new src\conexionPHPdata;
			$calc->creaTabla();
			$this->assertEquals(5,$calc->add(3,2));
			$this->assertEquals(true,$calc->PutData("NombreTest", "TextoTest", "GET"));
			$this->assertEquals(true,$calc->GetData());
		} 
	}

?>
