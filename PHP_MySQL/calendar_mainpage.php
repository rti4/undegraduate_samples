<?php
/*INSERT INTO Members VALUES('David', 'Kortney', 'Baldwin', 'username', 'password', 'username@utk.edu', '901-603-6162');

INSERT INTO Events VALUES('Calendar Complete', '12-31-09', 'The calendar successfully marks when events are occurring inside the table', '04:00:');
*/



session_start();

function update_event($event_name){
	echo "successful call of update_event() <br/>";
	echo "$event_name <br/>";
	create_input_form($event_name);
	
}

function create_input_form($event_name){
	echo "successful call of create input form()<br/>";
	echo "<form method=\"post\" >";
	echo "Event Name: <input type=\"text\" name=\"event_name\" value=\"$event_name\" />";
	
	echo "<div><input type=\"radio\" name=\"Update\" /> Update </div>";
	echo "<div><input type=\"submit\" value=\"submit\" /></div>";
	echo "</form>";

}

function load_events($admin, $password, $database){
	echo "<div>successful call of load events</div>";
	$admin_id ="username";
	$admin_pass="password";

	$connect = mysql_connect("server", $admin_id, $admin_pass);
	if(!$connect){
		die("Couldnt connect to" . mysql_error());
	}else{
		$db = "database table";
	}	
	mysql_select_db($db);
	
	$events = mysql_query("SELECT event_name, info, date, time FROM Events");
	
	while($evt = mysql_fetch_array($events)) {
		echo "<div>" . $evt["event_name"] . "<br />"
			. $evt["time"] . "</div>";
	}
	
}

function retreive_events_days($month){
	echo "<div>successful call of retrieve events</div>";
	$admin_id ="username";
	$admin_pass="password";

	$connect = mysql_connect("server", $admin_id, $admin_pass);
	if(!$connect){
		die("Couldnt connect to" . mysql_error());
	}else{
		$db = "database table";
	}	
	mysql_select_db($db);
	
	$events = mysql_query("SELECT date FROM Events");
	$days = array();
	$count =0;
	while($evt = mysql_fetch_array($events)) {
		
		echo "<div>" . $evt[0]. "</div>";
			//seperates date 11-12-09 to $char[0] = 11, $char[1] = 12...
			$chars = preg_split('/-/', $evt["date"],8, PREG_SPLIT_NO_EMPTY);
			if($chars[0] == $month){
				print_array($chars);
				$days[$count] = $chars[1];
				$count++;
				
			}
	}
	return $days;	
}


function print_events(){
	echo "<div>successful call of print_events</div>";
	$admin_id ="username";
	$admin_pass="password";

	$connect = mysql_connect("server", $admin_id, $admin_pass);
	if(!$connect){
		die("Couldnt connect to" . mysql_error());
	}else{
		$db = "database table";
	}	
	mysql_select_db($db);
	
	$days = array();
	$count =0;
	
	$events = mysql_query("SELECT event_name, info, date, time, id FROM Events");
	$am_pm=" ";
	echo '<table border="1" />
		  <th> Events Table </th>';
	while($evt = mysql_fetch_array($events)) {
	
		//splits time from military to ie. 23:00
		//p_t[0]= 23, p_t[1] = 00
		$parsed_time = preg_split('/:/', $evt["time"],8, PREG_SPLIT_NO_EMPTY);
		
		//checks for the correct pm/am symbol
		if(($parsed_time[0] > 12) && ($parsed_time[0] <24)){
			$am_pm = "pm";
		}elseif(($parsed_time[0] == 24)||(($parsed_time[0] > 0) && ($parsed_time[0] <12))){
			$am_pm = "am";
		}else{
			echo "error";
			die();

		}
		
		//deducts the military time appropriated from 23-12 = 11
		if($parsed_time[0] >12){
			$parsed_time[0] -=12;
				
		}
		echo '<tr>
				<td>'.$evt["event_name"].'</td>
				<td>'.$evt["date"].'</td>
				<td>'.$parsed_time[0].':'.$parsed_time[1].' '.$am_pm.'</td>
				<td width="300">'.$evt["info"].'</td>
				<td>'.$evt["id"].'</td>
			</tr>';

	}
	echo '</table>';
}
//prints the content of any array
function print_array($array){
	echo "<div>";
	foreach($array as $element){
		echo " ".$element. " ";
	}
	echo "</div>";
}

function find_match($array, $searchfor){
	$value = 0;
	foreach($array as $element){
		if($element == $searchfor){
			$value =1;
			break;
		}
	}

	return $value;
}

function calendar_matrix($row, $col, $month_array){
	$array_ebd =retreive_events_days(date("n"));
	$count =0;
	echo "<tr>";
	
	$d = $month_array[0]; //gets the first day of month ie 0,1,2,3,4,5,6

	//creates the correct number of blank td tags filled w/ -
	//create the correct number of initial days ie 1,2,3,4,5,6,7 
	// for first week
	repeat_td ($d, "-");
	$num_seq = 7-$d;

	repeat_td_num_seq($num_seq, 1, $array_ebd);
	echo "</tr>";
	
	//creates the next rows of inputs until I reach the last row	
	$day =$num_seq;
	$total_day = date("t");
	while($day < $total_day){
		if($day+7 < $total_day){
			echo "<tr>";
			repeat_td_num_seq(7, $day+1, $array_ebd);
			echo "</tr>";
			$day+=7;
		}else{
			break;
		}
	
	}
	//creates the last row by create the correct number of remaining days
	echo "<tr>";
	$offset =$total_day-$day;
	repeat_td_num_seq($offset, $day+1, $array_ebd);
	echo "</tr>";
	
}

//a function to repeatedly make td cells and their content
//content starts with some numerical value
function repeat_td_num_seq($num_seq, $start, $array){
	for($i=0; $i<$num_seq; $i++, $start++){
		if(find_match($array, $start)){
			echo "<td class=\"event_bgcolor\" value=\"$start\">".$start. "</td>";
		}else{	
			echo "<td value=\"$start\">".$start. "</td>";
		}
	}

}


//a function that repeatedly makes a td cell a certain # of times
//each cell contains the same data
function repeat_td ($num_repeats, $value){
	for($i=0; $i< $num_repeats; $i++){
		echo "<td id=\"$value\">".$value." </td>";

	}
}

//creates the calendar 
function construct_calendar($heading, $month_array){
	echo "<table border=\"1\">";

		echo "<th colspan=\"1000\">". $heading . "</th>";
		echo "<tr><td> Sun </td><td> Mon </td><td> Tues </td> <td> Wedn </td> <td> Thurs </td><td> Fri </td> <td> Sat </td> </tr>";
		$row=5;
		$col = 7;
		calendar_matrix($row, $col, $month_array);
		$d=$month_array[0];
			
	echo "</table>";



}
function create_calendar(){
	echo "<div>successful call of create calendar</div>";
	$admin_id ="username";
	$admin_pass="password";

	/*this makes reference to the global variables fname, mname, lname*/
	global $fname, $lname, $mname;
	$connect = mysql_connect("server", $admin_id, $admin_pass);
	if(!$connect){
		die("Couldnt connect to" . mysql_error());
	}else{
		$db = "database table";
	}

	mysql_select_db($db);
	$str_dow= date("l"); 
	$date_month= date("d");
	$dig_dow= date("w");
	$str_month = date("M");
	$dig_month= date("t");
	$fourdig_year = date("Y");
	$twodig_year = date("y");
	echo "<div>".$str_dow." ".$date_month." ".$dig_dow . "</div>";
	echo "<div>" . $str_month. " " . $dig_month . "</div>";
	echo "<div>" . $fourdig_year. " " . $twodig_year . "</div>";
	
	$dow_array= array(0,1,2,3,4,5,6);
	$month_array[31];
	
	for($i=0; $i< 31; $i++){
		$month_array[$i] = $i+1;
	}
	
	for($i=$date_month-1; $i>=0; $i--, $dig_dow--){
		if($dig_dow <=-1){
			$dig_dow = 6;
		}
		$month_array[$i] = $dig_dow;
	}
	
	$dig_dow = date("w");
	$dig_dow++;
	for($i =$date_month; $i<31; $i++, $dig_dow++){
		if($dig_dow >6){
			$dig_dow =0;
		}

		$month_array[$i] = $dig_dow;
	}

	//print_array($month_array);
	//print_array($dow_array);
	$jd = cal_to_jd(CAL_GREGORIAN, date("m"), date("d"), date("Y"));
	$string_month =(jdmonthname($jd,1));
	
	$heading= $string_month;
	construct_calendar($heading, $month_array);
	
}
		

function redirect( $url){
	if ( !headers_sent() ) {
		header('Location: '.$url);
	}else{
		echo '<script type="text/javascript">window.location.href="'.$url.'";</script>';
	}
}



/*if the session does not die, all variables used frequently become global variables*/
if (!(isset($_SESSION['username'])) || !(isset($_SESSION['password']))) {
		$url = "login.html";
		redirect($url);
}
$username = strip_tags($_SESSION['username']);
$password = strip_tags($_SESSION['password']);
$fname = strip_tags($_SESSION['fname']);
$lname = strip_tags($_SESSION['lname']);
$mname= strip_tags($_SESSION['mname']);

echo "<html><head>
		<title>Member's Page</title><link rel=\"stylesheet\" type=\"text/css\" href=\"bet.css\" />
		<!--TELLS THE BROWSER NOT TO CACHE INFORMATION-->
		<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">
		</head>
		<body>
		<div> Hello $fname $lname </div>
		
		";

create_calendar();
$array_ebd =retreive_events_days(date("n"));
print_events();

//CREATE THE RADIO FOR THE UPDATE, ADD, DELETE Calendar
echo '<form action="process_calendar_input.php" method="post" name="calendar_input"/>';
echo '
			
			<table border=\"1\"><th width="300px" colspan="10"> What Do You Want To Do? </th></table>
			<div>
			<div>Event name: <input type="text" maxlength="19" name="event_name" size="20"/></div>
			<select name="drop_action">
					<option name="null" value="--"> -- </option>
					<option name="update" value="update"/> Update </option> 
					<option name="add" value="add"/> Add </option>
					<option name="delete" value="delete"/> Delete </option>
			</select>
			<select name="drop_month">
					<option name="null" value="--"> -- </option>
					<option name="January" value="1"> 1 </option>
					<option name="February" value="2"> 2 </option>
					<option name="March" value="3"> 3 </option>
					<option name="April" value="4"> 4 </option>
					<option name="May" value="5"> 5 </option>
					<option name="June" value="6"> 6 </option>
					<option name="July" value="7"> 7 </option>
					<option name="August" value="8"> 8 </option>
					<option name="September" value="9"> 9 </option>
					<option name="October" value="10"> 10 </option>
					<option name="November" value="11"> 11 </option>
					<option name="December" value="12"> 12 </option>
			</select>
			<select name="drop_day">
					<option name="null" value="--"> -- </option>
					<option name="day_1" value="1"> 1 </option>
					<option name="day_2" value="2"> 2 </option>
					<option name="day_3" value="3">	3 </option>
					<option name="day_4" value="4"> 4 </option>
					<option name="day_5" value="5"> 5 </option>
					<option name="day_6" value="6"> 6 </option>
					<option name="day_7" value="7"> 7 </option>
					<option name="day_8" value="8"> 8 </option>
					<option name="day_9" value="9"> 9 </option>
					<option name="day_10" value="10"> 10 </option>
					<option name="day_11" value="11"> 11 </option>
					<option name="day_12" value="12"> 12 </option>
					<option name="day_13" value="13"> 13 </option>
					<option name="day_14" value="14"> 14 </option>
					<option name="day_15" value="15"> 15 </option>
					<option name="day_16" value="16"> 16 </option>
					<option name="day_17" value="17"> 17 </option>
					<option name="day_18" value="18"> 18 </option>
					<option name="day_19" value="19"> 19 </option>
					<option name="day_20" value="20"> 20 </option>
					<option name="day_21" value="21"> 21 </option>
					<option name="day_22" value="22"> 22 </option>
					<option name="day_23" value="23"> 23 </option>
					<option name="day_24" value="24"> 24 </option>
					<option name="day_25" value="25"> 25 </option>
					<option name="day_26" value="26"> 26 </option>
					<option name="day_27" value="27"> 27 </option>
					<option name="day_28" value="28"> 28 </option>
					<option name="day_29" value="29"> 29 </option>
					<option name="day_30" value="30"> 30 </option>
					<option name="day_31" value="31"> 31 </option>
			</select>
			<select name="drop_year">
					<option name="null" value="--"> -- </option>
					<option name="year_2009" value="09"> 2009 </option>
					<option name="year_2010" value="10"> 2010 </option>
					<option name="year_2011" value="11"> 2011 </option>
					<option name="year_2012" value="12"> 2012 </option>
					<option name="year_2013" value="13"> 2013 </option>
			</select>
			<div> Time: </div>
			<select name="drop_hour">
				<option name="null" value="--"> -- </option>
				<option name="hour_1" value="1"> 1 </option>
				<option name="hour_2" value="2"> 2 </option>
				<option name="hour_3" value="3"> 3 </option>
				<option name="hour_4" value="4"> 4 </option>
				<option name="hour_5" value="5"> 5 </option>
				<option name="hour_6" value="6"> 6 </option>
				<option name="hour_7" value="7"> 7 </option>
				<option name="hour_8" value="8"> 8 </option>
				<option name="hour_9" value="9"> 9 </option>
				<option name="hour_10" value="10"> 10 </option>
				<option name="hour_11" value="11"> 11 </option>
				<option name="hour_12" value="12"> 12 </option>
			</select>
			
			<select name="drop_min">
				<option name="null" value="--"> -- </option>
				<option name="min_00" value="00"> 00 </option>
				<option name="min_30" value="30"> 30 </option>

			</select>

			<select name="drop_ampm">
				<option name="null" value="--"> -- </option>
				<option name="am" value="am"> am </option>
				<option name="pm" value="pm"> pm </option>
			</select>
			<div>Event Description: </div>
			<div><textarea rows="3" cols="50" maxlength="200" wrap="virtual" name="event_information"></textarea></div>
			</div>
			<div>ID#: <input type="text" name="id#" maxlength="2" size="1"/> </div>
		';

		echo '<input type="submit" value ="Submit" /></form>';
		
echo '<p><a href="log_out.php"> Click here to logout! </a> </p>';


?>
