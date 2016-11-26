<?php
/*INSERT INTO Members VALUES('David', 'Kortney', 'Baldwin', 'username', 'password', 'username@utk.edu', '901-603-6162');

INSERT INTO Events VALUES('TEST', '11-19-09', 'This is the first time I have created an event in the database', '22:40');
*/



session_start();

function validate_userid_pass(){
	$admin_id ="username";
	$admin_pass="password";

	$connect = mysql_connect("server", $admin_id, $admin_pass);
	if(!$connect){
		die("Couldnt connect to" . mysql_error());
	}else{
		$db = "database table";
	}
	mysql_select_db($db);
	echo "Connected to database" .$db. "...<br/>\n";
	if(!($_SESSION['username']) && !($_SESSION['password'])){
		echo "password or username not stored";
		$_SESSION['username']= $_POST['username'];
		$_SESSION['password']= $_POST['password'];
		$username = $_SESSION['username'];
		$password = $_SESSION['password'];
	
		echo "$password, $username<br/>";
	}else{
		
		echo "password or username stored";
		
		$username = $_SESSION['username'];
		$password = $_SESSION['password'];
	
		echo "$password, $username<br/>";
	}
	$matches = mysql_query("SELECT COUNT(username) FROM Members WHERE username='$username' AND password='$password'");
	$matches = mysql_fetch_array($matches);

	if($matches[0] == 1){
		$fname=mysql_query("SELECT fname FROM Members WHERE username='$username' AND password= '$password'");
		$fname=mysql_fetch_array($fname);
		$mname=mysql_query("SELECT mname FROM Members WHERE username='$username' AND password= '$password'");
		$mname=mysql_fetch_array($mname);
		$lname=mysql_query("SELECT lname FROM Members WHERE username='$username' AND password= '$password'");
		$lname=mysql_fetch_array($lname);
	
		/*creates points to the name*/
		$fname = $fname[0];
		$mname = $mname[0];
		$lname = $lname[0];
		echo "$fname, $lname, $mname<br/>";
		$_SESSION['fname']= $fname;
		$_SESSION['mname']= $mname;
		$_SESSION['lname']= $lname;
		
		
	}else{
		echo "$fname, $lname, $mname<br/>";

		$matches= mysql_query("SELECT COUNT(username) FROM Members WHERE username='$username'");
		$matches = mysql_fetch_array($matches);
		if($matches[0] == 1){
			echo "<div> Invalid password. Go back and try again. </div>";
		}else{
			echo "<div> Invalid username. Go back and try again. </div>";
		}
		return false;
	}
	return true;
}

function redirect( $url){
	if ( !headers_sent() ) {
		header('Location: '.$url);
	}else{
		echo '<script type="text/javascript">window.location.href="'.$url.'";</script>';
	}
}




if(!validate_userid_pass()){
	$URL="login.html";
	redirect($URL);
	session_destroy();
}else{
	echo "go to next page";
	$URL="member_login.php";
	redirect($URL);
}


?> 

