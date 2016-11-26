<?php
/*INSERT INTO Members VALUES('David', 'Kortney', 'Baldwin', 'username', 'password', 'username@utk.edu', '901-603-6162');

INSERT INTO Events VALUES('Calendar Complete', '12-31-09', 'The calendar successfully marks when events are occurring inside the table', '04:00:');
*/



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
	connect_db();
	$events = mysql_query("SELECT event_name, info, date, time FROM Events");
	
	while($evt = mysql_fetch_array($events)) {
		echo "<div>" . $evt["event_name"] . "<br />"
			. $evt["time"] . "</div>";
	}
	
}

function retreive_events_days($month){
	connect_db();
	$events = mysql_query("SELECT date FROM Events");
	$days = array();
	$count =0;
	while($evt = mysql_fetch_array($events)) {
			//seperates date 11-12-09 to $char[0] = 11, $char[1] = 12...
			$chars = preg_split('/-/', $evt["date"],8, PREG_SPLIT_NO_EMPTY);
			if($chars[0] == $month){
				$days[$count] = $chars[1];
				$count++;
				
			}
	}
	return $days;	
}


function print_events(){
	connect_db();
	
	$events = mysql_query("SELECT event_name, info, date, time, id FROM Events");
	$am_pm=" ";
	echo '<table border="1" />
		  <th colspan="5"> Events Table </th>';
	while($evt = mysql_fetch_array($events)) {
	
		//splits time from military to ie. 23:00
		//p_t[0]= 23, p_t[1] = 00
		$parsed_time = preg_split('/:/', $evt["time"],8, PREG_SPLIT_NO_EMPTY);
		
		//checks for the correct pm/am symbol
		if(($parsed_time[0] >= 12) && ($parsed_time[0] <24)){
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
				<td width="1">'.$evt["id"].'</td>
				<td>'.$evt["event_name"].'</td>
				<td>'.$evt["date"].'</td>
				<td>'.$parsed_time[0].':'.$parsed_time[1].' '.$am_pm.'</td>
				<td width="300">'.$evt["info"].'</td>
				
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

//this function will search an array for a particular match
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

//constructs the two dimension calendar
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

//driver for the calendar 
function construct_calendar($heading, $month_array){
	echo '<table border="1">';
		echo '<th colspan="7">'. $heading . '</th>';
		echo "<tr><td> Sun </td><td> Mon </td><td> Tues </td> <td> Wedn </td> <td> Thurs </td><td> Fri </td> <td> Sat </td> </tr>";
		$row=5;
		$col = 7;
		calendar_matrix($row, $col, $month_array);
		$d=$month_array[0];
			
	echo "</table>";
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

//retrieves all of the current date, month, etc from the server 
//passes the information to construct_calendar() that
function create_calendar(){
	$date_month= date("d");
	$dig_dow= date("w");
	$dig_month= date("t");
	
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
?>
