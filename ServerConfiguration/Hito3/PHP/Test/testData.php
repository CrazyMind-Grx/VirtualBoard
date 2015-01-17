<?php 
namespace PHP\Test;
require_once('../conexionPHPdata.php');

class PutDataTest extends \PHPUnit_Framework_TestCase{
	
	/**
	 *
	 *	@return PHPUnit_Extensions_Database_DB_IDatabaseConnection
	 *
	 *
	 */
	public function getConexion(){
		$conexion = mysql_connect("127.5.40.130:3306","adminC77ifqE","7NkYeHz1_G-K") or die("Sin conexion");
		return $this-> createDefaultDBConnection($conexion, ':memory:');
	}


	/**
	 *
	 * @return PHPUnit_Extensions_Database_DataSet_IDataSet
	 *
	 */
	public function getDataSet()
    {
        return $this->createFlatXMLDataSet(dirname(__FILE__).'/_files/guestbook-seed.xml');
    }
}





?> 
