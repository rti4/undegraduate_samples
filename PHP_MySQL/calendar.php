<?php

$admin_id="username";
$admin_pass="password";

$con=mysql_connect("server", $admin_id, $admin_pass);
if(!$con){
	die("Couldnt connect to" . mysql_error());
}else{
	$database= "database table";
}

mysql_select_db($database);
echo "Connected to $database <br/>";




?>
