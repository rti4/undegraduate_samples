<?php
function redirect( $url){
	if ( !headers_sent() ) {
		header('Location: '.$url);
	}else{
		echo '<script type="text/javascript">window.location.href="'.$url.'";</script>';
	}
}
function connect_db(){
	$admin_id ="username";
    $admin_pass="password";

	$connect = mysql_connect("server", $admin_id, $admin_pass);
	if(!$connect){
		die("Couldnt connect to" . mysql_error());
	}else{
	    $db = "database table";
	}
	
	mysql_select_db($db);
}
function process_add(){
	
	$redirection="member_login.php";
	$month= $_POST['drop_month'];
	$day = $_POST['drop_day'];
	$year = $_POST['drop_year'];
	$event_name= $_POST['event_name'];
	$hr = $_POST['drop_hour'];
	$min= $_POST['drop_min'];
	$am_pm = $_POST['drop_ampm'];
	$event_descript = $_POST['event_information'];
	connect_db();
	$id_resource = mysql_query("SELECT count(id) FROM Events");
	$id= mysql_fetch_array($id_resource);
	$id[0] += 1;	
	echo "$event_name $month $day $year $id[0] <br/>";
	echo "$event_descript <br/>";
	echo "$hr $min $am_pm";
	if(($hr == '--') || ($min == '--') || ($am_pm == '--') || ($month == '--') || ($day == '--') || ($year == '--')){
		echo "invalid input";
		redirect($redirection);
	}
	if($am_pm == 'am'){
		if($hr < 10){
			$hr = "0".$hr;
		}else if($hr == 12){
			$hr=24;
		}else{
			echo "error";
		}
	}elseif(($am_pm == 'pm') && ($hr != 12)){
		$hr+=12;
	}else{
		echo "unexpected time";
		redirect($redirection);
	}

	mysql_query("INSERT INTO Events(event_name,date,info,time,id) VALUES('$event_name','$month-$day-$year', '$event_descript', '$hr:$min', '$id[0]')");

}

function process_update(){
	$redirection="member_login.php";
	$month= $_POST['drop_month'];
	$day = $_POST['drop_day'];
	$year = $_POST['drop_year'];
	$event_name= $_POST['event_name'];
	$hr = $_POST['drop_hour'];
	$min= $_POST['drop_min'];
	$am_pm = $_POST['drop_ampm'];
	$event_descript = $_POST['event_information'];
	$id_num = $_POST['id#'];
	connect_db();
	
	if(($hr == '--') || ($min == '--') || ($am_pm == '--') || ($month == '--') || ($day == '--') || ($year == '--')){
		echo "invalid input";
		redirect($redirection);
	}
	//string compare
	if($am_pm == 'am'){
		if($hr < 10){
			$hr = "0".$hr;
		}else if($hr ==12){
			$hr=24;
		}else{
			echo "error";
		}
	}elseif(($am_pm == 'pm')&&($hr!=12)){
		$hr+=12;
	}else{
		echo "unexpected time";
		redirect($redirection);
	}

	mysql_query("UPDATE Events SET time='$hr:$min', date='$month-$day-$year', info='$event_descript', event_name='$event_name' WHERE id='$id_num'");
	//echo $event_resource['event_name'];

}

function process_delete(){
	$redirection="member_login.php";
	$month= $_POST['drop_month'];
	$day = $_POST['drop_day'];
	$year = $_POST['drop_year'];
	$event_name= $_POST['event_name'];
	$hr = $_POST['drop_hour'];
	$min= $_POST['drop_min'];
	$am_pm = $_POST['drop_ampm'];
	$event_descript = $_POST['event_information'];
	$id_num = $_POST['id#'];
	connect_db();
	
	echo "$id_num";
	
	if(($hr == '--') || ($min == '--') || ($am_pm == '--') || ($month == '--') || ($day == '--') || ($year == '--')){
		echo "invalid input";
		redirect($redirection);
	}

	if($am_pm == 'am'){
		if($hr < 10){
			$hr = "0".$hr;
		}else if($hr==12){
			$hr=24;
		}else{
			echo "error";
		}
	}elseif(($am_pm == 'pm') && ($hr!=12)){ //12:00pm converts to 1200 hrs no need to increment it
		$hr+=12;
	}else{
		echo "unexpected time";
		redirect($redirection);
	}
	
	mysql_query("DELETE FROM Events WHERE date='$month-$day-$year' AND time='$hr:$min' AND id='$id_num'");
	
	//mysql_query("DELETE FROM Events WHERE id='$id_num'");
	
	


}

$redirection="member_login.php";
$action = $_POST['drop_action'];
if($action== '--'){
	echo "no action was given";
	redirect($redirection);
}elseif($action == 'add'){
	echo "action is add";
	process_add();
	redirect($redirection);
}elseif ($action == 'update'){
	echo "action is update";
	process_update();
	redirect($redirection);
}elseif($action == 'delete'){
	echo "action is delete";
	process_delete();
	redirect($redirection);
}else{
	echo "action error";
}



?>
