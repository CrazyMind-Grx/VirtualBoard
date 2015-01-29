<?php
/**
 * Created by PhpStorm.
 * User: eduardo
 * Date: 29/01/15
 * Time: 13:27
 */

namespace src;


use PDO;

class Testclassphpdata extends \PHPUnit_Framework_TestCase {

    /** @var conexionphpdata */
    protected $_conexion;
    private  $pdo;

    /**
     * Clase para inicializar la conexionphpdata
     */
    protected  function setUp()
    {

        $this->pdo = new PDO($GLOBALS['db_dsn'], $GLOBALS['db_username'], $GLOBALS['db_password']);
        $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $this->_conexion = new conexionPHPdata($this->pdo);
    }

    /**
     * @covers conexionPHPdata::getData
     */
    public function testGetData()
    {
        $this->assertEquals(0,$this->_conexion->GetData());
    }


    /**
     * @covers conexionPHPdata::PutData
     */
    public function testPutData()
    {
        $this->assertEquals(0,$this->_conexion->PutData("nombre","texto","Get"));
    }

}
