<?php

$username = "username";
$password = "password";
$database = "database table";

$connect = mysql_connect("server", $username, $password);

/*checks to see if we were able to connect*/
if(!$connect){
	die("Couldnt connect to database @:" . mysql_error());
}

/*then select the appropriate database*/
mysql_select_db($database);

echo "Connected to database ". $database. "...<br/>\n";
/*
mysql_query("DROP TABLE Events");

$statement = "CREATE TABLE Events (event_name varchar(20), date char(8), time char(5), info varchar(150), time char(5))";

mysql_query($statement);
*/
mysql_close($connect);
echo "Connect closed. Task Completed at " .date("h:i:s") . ".<br/>\n";

?>

