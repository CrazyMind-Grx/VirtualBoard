<?php

	class conexionPHPdataTest extends PHPUnit_Framework_TestCase
	{
	
		public function test_conexionEstablecida()
		{
			
			$a = new conexionPHPdataTest();
		
			$this->assertTrue($a->GetData() !== false);
		
		}
	
	}

?>