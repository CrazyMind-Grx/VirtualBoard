<?php
/**
* 
*/
class pruebaTest extends PHPUnit_Framework_TestCase
{
	
	
	public function testValidResult(){
		$calc = new src\prueba;
		$this->assertEquals(5,$calc->add(2,3));
	}
}
?>
