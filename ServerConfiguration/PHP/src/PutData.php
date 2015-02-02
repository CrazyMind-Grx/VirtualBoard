<?php
require_once('conexionPHPdata.php');

$data = new src\conexionPHPdata;

$data->PutData($_REQUEST["nombre"],$_REQUEST["texto"],$_REQUEST["modo"]);

?>

