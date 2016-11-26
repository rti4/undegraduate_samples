<?php


$username = "username";
$password = "password";

$con = mysql_connect("server", $username, $password);
if(!$con){
	die("Could not connect to ". mysql_error());
}

$database= "database table";

mysql_select_db($database);

echo "Connected to database " . $database . "...<br/>\n";

//COMMENTED OUT TO PROTECT POSSIBLE DESTRUCTION OF TABLE
/*mysql_query("DROP TABLE Members");
$statement = "CREATE TABLE Members (fname varchar(20), mname varchar(20), lname varchar(20), username varchar(10), password varchar(15), email varchar(30), phone varchar(12))";

mysql_query($statement);
*/
mysql_close($con);
echo "Connection closed. Task Completed at " . date("h:i:s"). " .<br/>\n"; 
?>





