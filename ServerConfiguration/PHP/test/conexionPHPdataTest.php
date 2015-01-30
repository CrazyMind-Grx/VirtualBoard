<?php

	/*
	 *	Class para testeo
	 */

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{	
	public function testValidResult(){
		$calc = new src\conexionPHPdata;
		$this->assertEquals(5,$calc->add(2,3));
	}
	}

?>
