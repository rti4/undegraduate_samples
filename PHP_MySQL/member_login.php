<?php
/*INSERT INTO Members VALUES('David', 'Kortney', 'Baldwin', 'username', 'password', 'username@utk.edu', '901-603-6162');
mysql -u username -h server -p database table


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
		  <th> Events Table </th>';
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


//-------------MAIN SECTION OF PAGE -----------------------

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

?>
<html>
<head>
	<title>Member's Page</title>
	<link rel="stylesheet" type="text/css" href="bet.css"/>
	<!--TELLS THE BROWSER NOT TO CACHE INFORMATION-->
	<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">



	<script type="text/javascript"> 
	
	/*these functions control highlight fields of form below*/
	/*The month*/
	function unstar_month(){
		//unstar
		document.getElementById('drop_month').style.backgroundColor="white";
		document.getElementById('drop_day').style.backgroundColor= "white";
		document.getElementById('drop_year').style.backgroundColor="white";
	}
	
	function star_month(){
		unstar_month();
		//star
		document.getElementById('drop_month').style.backgroundColor="red";
		document.getElementById('drop_day').style.backgroundColor= "red";
		document.getElementById('drop_year').style.backgroundColor="red";
	}
	
	
	/*Time field*/
	function unstar_time(){
		//unstar
		document.getElementById('drop_hour').style.backgroundColor="white";
		document.getElementById('drop_min').style.backgroundColor= "white";
		document.getElementById('drop_ampm').style.backgroundColor="white";
	}
	
	function star_time(){
		unstar_time();
		//star
		document.getElementById('drop_hour').style.backgroundColor="red";
		document.getElementById('drop_min').style.backgroundColor= "red";
		document.getElementById('drop_ampm').style.backgroundColor="red";
	}
	
	function unstar_all(){
		unstar_month();
		unstar_time();
		unstar_eventinfo();
		unstar_event();
		unstar_idnum();
	}
	
	function star_default(){
		star_month();
		star_event();
		star_time();
		star_eventinfo();

	}
	
	function check_default(){
		if((check_month_time() == true) && (check_idnum() == true)){
			return true;
		}else{
			return false;
		}
	}
	function check_month_time(){
		var month = false;
		var day = false;
		var year = false;
		var hour = false;
		var min = false;
		var ampm = false;
		
		var sentence = '';
		if(document.getElementById('drop_month').value != '--'){
			month = true;
		
		}else{
			sentence= sentence+' month ';
		}
		if(document.getElementById('drop_day').value != '--'){
			day = true;
		}else{
			sentence= sentence+' day ';
		}
		if(document.getElementById('drop_year').value != '--'){
			year = true;
		}else{
			sentence = sentence+ ' year ';
		}
		
		if(document.getElementById('drop_hour').value != '--'){
			hour = true;
		}else{
			
			sentence = sentence+ ' hour ';
		}
		if(document.getElementById('drop_min').value != '--'){
			min = true;
		}else{
			sentence = sentence+' minute ';
		}
		if(document.getElementById('drop_ampm').value != '--'){
			ampm = true;
		}else{
			sentence = sentence + ' am/pm ';
		}
		
		if((month == false) || (day == false) || (year == false) || (hour == false) || (min == false) || ( ampm == false)){
			//alert(sentence + ' are needed before submiting.'); 
			return false;
		}else{
			return true;
		}
	}
	
	/*The Event field*/
	function unstar_event(){
		//unstar
		document.getElementById('event_name').style.backgroundColor= "white";
	}
	
	function star_event(){
		unstar_event();
		//star
		document.getElementById('event_name').style.backgroundColor= "red";
	}
	
	/*Event description textbox*/
	function unstar_eventinfo(){
		//unstar
		document.getElementById('event_information').style.backgroundColor= "white";
	}
	
	function star_eventinfo(){
		unstar_eventinfo();
		//star
		document.getElementById('event_information').style.backgroundColor= "red";
	}
	
	/*id number*/
	function unstar_idnum(){
		//unstar
		document.getElementById('idnum').disabled = true;
		document.getElementById('idnum').style.backgroundColor= "white";
	}
	
	function star_idnum(){
		unstar_idnum();
		//star
		document.getElementById('idnum').disabled= false;
		document.getElementById('idnum').style.backgroundColor= "red";
	}
	
	/*The driver for the above functions*/
	function star(){
		//alert(("drop_action has changed");
		//first clear all tags
		document.getElementById('drop_action').style.backgroundColor="white";
		
		//star required tags
		//document.getElementById('drop_action').style.backgroundColor="red";
		var action= document.getElementById('drop_action').value;
		//////alert((action);
		if(action == 'update'){
			////alert(("highlight requirements for update");
			star_default();
			star_idnum();
			
		}else if(action == 'delete'){
			//alert(("hightlight requirements for delete");
			star_month();
			star_time();
			unstar_eventinfo();
			unstar_event();
			star_idnum();
			
		}else if (action == 'add'){
			////alert(("hightlight requirements for add");
			star_default();
			unstar_idnum();
			
		}else if(action == '--'){
			////alert(("highlight no requirements");
			unstar_all();
			unstar_idnum();
		}else {
			////alert(("this case should never happen");
			
		}
			
	}
	
	function unstar(element){
		var elem = element;
		if(document.getElementById(elem).value != '--'){
			document.getElementById(elem).style.backgroundColor="white";
		}
	}

	function check_input(element){
		//alert(("check_input");
		var elem=element;
		if(document.getElementById(elem).value != ''){
			document.getElementById(elem).style.backgroundColor="white";
			return true;
		}
		return false;
	}
	
	function check_idnum(){
		var tag = document.getElementById('idnum');
		if((tag.disabled == false) && !((tag.value >=0) && (tag.value <=99))){
			//alert('Only ID# from 0-99 are accepted');
			return false;
		}else if((tag.disabled == false) && (tag.value=='')){
			//alert('Only ID# from 0-99 are accepted');
			return false;
		}else if((tag.value >=0) && (tag.value <=99)){
			return true;
		}else{
			return false;
		}
		
	}
	function check_allinputs(){
		check_input('event_name'); 
		check_input('event_information'); 
		check_input('idnum');
		if((check_input('event_name') == true) && (check_input('event_information') == true) &&(check_input('idnum') == true)){
			return true;
		}
		
	}
	
	
	/*checks all values that are required*/
	function pre_submitcheck(){
		var action = document.getElementById('drop_action').value;
		//alert("presubmitcheck called for" + action);
		if(action == 'update'){
			////alert(("highlight requirements for update");
			if((check_default() == true) && (check_allinputs() == true)){
				document.getElementById('submitbutton').disabled = false;
			}
			
		}else if(action == 'delete'){
			//alert(("hightlight requirements for delete");
			if((check_month_time() == true) && (check_idnum() == true)){
				document.getElementById('submitbutton').disabled = false;
			}
			
		}else if (action == 'add'){
			////alert(("hightlight requirements for add");
			if((check_default() == true) && (check_input('event_name') == true) && (check_input('event_information'))){
					document.getElementById('submitbutton').disabled = false;
			}
		}else if(action == '--'){
			////alert(("highlight no requirements");
			document.getElementById('submitbutton').disabled = true;
		}else {
			////alert(("this case should never happen");
		}
		
		
	}
	function disable_submit(){
		document.getElementById('submitbutton').disabled = true;
		pre_submitcheck();
	}
	
	/*AJAX CODE */
	//Get the HTTP Object
	function getHTTPObject(){
		if(window.ActiveXObject){
			//this if the browser is IE6, IE5
			//alert("Ur using IE");
			return new ActiveXObject("Microsoft.XMLHTTP");

		}else if (window.XMLHttpRequest){
			//this if the browser is IE7+, Firefox, Chrome, Opera, Safari
			//alert("ur using NETSCAPE");
			return new XMLHttpRequest();
		}else{
			//
			alert("Your browser does not supprot AJAX.");
			return null;
		}
	}

	//outputs which month were working with
	function show_calendar(){
		//alert("do work");
		httpObject= getHTTPObject();
		if(httpObject!= null){
			httpObject.open("GET", "generate_schedule.php",false);
			httpObject.send(null);
			var display_calendar = httpObject.responseText;
			document.getElementById('calendar').innerHTML = display_calendar;
		}else{
			alert("ajax error");
		}
	}

	
	function hover(element){
		//alert("You have moused over " +element.id);
		element.style.color="blue";

	}

	function no_hover(element){
		//alert("You have moused out of " +element.id);
		element.style.color="#000000";
	}
	</script>
</head>

<body onLoad="star(); check_allinputs(); disable_submit(); pre_submitcheck(); show_calendar();">

<!--- 
echo '<div> Hello $fname $lname </div>;
	create_calendar();
	$array_ebd =retreive_events_days(date("n"));
	print_events();
	';
-->
<div id="calendar" ></div>


<form action="process_calendar_input.php" method ="post" id= "calendar_input" onChange="disable_submit();pre_submitcheck();">
	<table border="1">
	<tr>
	<td><div id="action_id"> I would like to </div></td>
	<td>
		<select name="drop_action" id="drop_action" onChange= "star();" onClick= "star();">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="update" id="update" value="update" onClick="unstar('drop_action');">Update</option>
			<option name="add" id="add" value="add" onClick="unstar('drop_action');"> Add </option>
			<option name="delete" id="delete" value="delete" onClick="unstar('drop_action');">Delete</option>
		</select>
	</td>
	<tr>
	<tr>
	<td><div id="event_id"> Event name:</div></td>
	<td><input type="text" maxlength="19" name="event_name" id="event_name" size="20" onClick="check_input('event_name');" onChange="check_input('event_name');"></td>
	</tr>
	<tr>
	<td><div id="date_id"> Date (month, day, year)</div></td>
	<td>
		<select name="drop_month" id="drop_month" onChange="unstar('drop_month');" onClick="unstar('drop_month');">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="January" id="January" value="1" > 1 </option>
			<option name="February" id="February" value="2"> 2 </option>
			<option  name="March" id="March" value="3"> 3 </option>
			<option name="April" id="April" value="4"> 4 </option>
			<option name="May" id="May" value="5" > 5 </option>
			<option name="June" id="June" value="6" > 6 </option>
			<option name="July" id="July" value="7" > 7 </option>
			<option name="August" id="August" value="8"> 8 </option>
			<option name="September" id="September" value="9" > 9 </option>
			<option name="October" id="October" value="10" > 10 </option>
			<option name="November" id="November" value="11" > 11 </option>
			<option name="December" id="December" value="12" > 12 </option>
		</select>
		
		<select name="drop_day" id="drop_day" onChange="unstar('drop_day');" onClick="unstar('drop_day');">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="day_1" id="day_1" value="1" > 1 </option>
			<option name="day_2"id="day_2" value="2" > 2 </option>
			<option name="day_3"id="day_3" value="3" > 3 </option>
			<option name="day_4"id="day_4" value="4" > 4 </option>
			<option name="day_5"id="day_5" value="5" > 5 </option>
			<option name="day_6"id="day_6" value="6" > 6 </option>
			<option name="day_7"id="day_7" value="7" > 7 </option>
			<option name="day_8"id="day_8" value="8" > 8 </option>
			<option name="day_9"id="day_9" value="9" > 9 </option>
			<option name="day_10" id="day_10" value="10" > 10 </option>
			<option name="day_11" id="day_11" value="11" > 11 </option>
			<option name="day_12" id="day_12" value="12" > 12 </option>
			<option name="day_13" id="day_13" value="13" > 13 </option>
			<option name="day_14" id="day_14" value="14" > 14 </option>
			<option name="day_15" id="day_15" value="15" > 15 </option>
			<option name="day_16" id="day_16" value="16" > 16 </option>
			<option name="day_17" id="day_17" value="17" > 17 </option>
			<option name="day_18" id="day_18" value="18" > 18 </option>
			<option name="day_19" id="day_19" value="19" > 19 </option>
			<option name="day_20" id="day_20" value="20" > 20 </option>
			<option name="day_21" id="day_21" value="21" > 21 </option>
			<option name="day_22" id="day_22" value="22" > 22 </option>
			<option name="day_23" id="day_23" value="23" > 23 </option>
			<option name="day_24" id="day_24" value="24" > 24 </option>
			<option name="day_25" id="day_25" value="25" > 25 </option>
			<option name="day_26" id="day_26" value="26" > 26 </option>
			<option name="day_27" id="day_27" value="27" > 27 </option>
			<option name="day_28" id="day_28" value="28" > 28 </option>
			<option name="day_29" id="day_29" value="29" > 29 </option>
			<option name="day_30" id="day_30" value="30" > 30 </option>
			<option name="day_31" id="day_31" value="31" > 31 </option>
		</select>
		<select name="drop_year" id="drop_year" onChange="unstar('drop_year');" onClick="unstar('drop_year');">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="year_2010" id="year_2010" value="10" > 2010 </option>
			<option name="year_2011" id="year_2011" value="11" > 2011 </option>
			<option name="year_2012" id="year_2012" value="12" > 2012 </option>
		</select>
		</td>
		</tr>
		<tr>
		<td><div id="time_id">Time (hr:min:am/pm)</div></td>
		<td>
		<select name="drop_hour" id="drop_hour" onChange()="unstar('drop_hour');" onClick()="unstar('drop_hour');">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="hour_1" id="hour_1" value="1" > 1 </option>
			<option name="hour_2" id="hour_2" value="2"> 2 </option>
			<option name="hour_3" id="hour_3" value="3" > 3 </option>
			<option name="hour_4" id="hour_4" value="4" > 4 </option>
			<option name="hour_5" id="hour_5" value="5" > 5 </option>
			<option name="hour_6" id="hour_6" value="6" > 6 </option>
			<option name="hour_7" id="hour_7" value="7" > 7 </option>
			<option name="hour_8" id="hour_8" value="8" > 8 </option>
			<option name="hour_9" id="hour_9" value="9" > 9 </option>
			<option name="hour_10" id="hour_10" value="10" > 10 </option>
			<option name="hour_11" id="hour_10" value="11" > 11 </option>
			<option name="hour_12" id="hour_10" value="12" > 12 </option>
		</select>
		<select name="drop_min" id="drop_min" onClick="unstar('drop_min');" onChange="unstar('drop_min');">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="min_00" id="min_00" value="00" > 00 </option>
			<option name="min_30" id="min_30" value="30" > 30 </option>
		</select>
		
		<select name="drop_ampm" id="drop_ampm"  onClick="unstar('drop_ampm');" onChange="unstar('drop_ampm');">
			<option name="null" id="null" value="--" checked> -- </option>
			<option name="am" id="am" value="am" > am </option>
			<option name="pm" id="pm" value="pm" > pm </option>
		</select>
		</td>
		</tr>
		<tr>
		<td><div id="eventdescript_id">Event Description </div></td>
		<td>
		<textarea row="3" cols="50" maxlength="200" wrap="virtual" name="event_information" id="event_information" onChange="check_input('event_information');"> </textarea>
		</td>
		</tr>
		<tr>
		<td><div id="idnum_id"> ID# (0-99): </div></td>
		<td><input type="text" name="id#" id="idnum" maxlength="2" size="2" onChange="check_input('idnum');"></td>
		</tr>
	</table>
	<div> <input type="submit" value="Submit" id="submitbutton"/></div>
	</form>
<p><a href="log_out.php"> Click here to logout </a></p>

</body>
</html>
