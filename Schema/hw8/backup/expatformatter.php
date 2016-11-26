<?php

$type_stack = array();
$value = 0;
$num_cd = 0;
$name = "";
function start_element($parser, $element_name, $element_attrs){
	global $type_stack;
	global $value;
	global $num_cds;
	global $name;


	switch($element_name){
		case 'CD': 
			printf("<hr/>");
			break;
		case 'ARTIST':
			printf("<li>");	
			break;
		case 'PRICE':
			printf("<li>");
			break;
		case 'YEAR':
			printf("<li>");
			break;

	}	
	
	array_push($type_stack, $element_name);
}


function end_element($parser, $element_name){
	switch($element_name){
		case 'TITLE':
			printf("<ul>", $element_name);
			break;
		case 'ARTIST':
			printf("</li>");
			break;
		case 'YEAR':
			printf("</li></ul>");
			break;
		case 'PRICE':
			printf("</li>");
			break;


	}



}

function char_handler($parser, $data){
	global $type_stack;
	global $num_cds;
	global $value;
	global $name;

	switch(end($type_stack)){
		case 'TITLE':
			printf("<h3>%s</h3>\n", $data);
				break;
	}

	switch(end($type_stack)){
		case 'ARTIST':
			printf("%s\n", $data);
			break;
		case 'PRICE':
			if($data <= 9.00){
				printf("<font color=blue>");
			}else{
				printf("<font color=green>");
			}
			printf("%s\n", $data);
			
			if($data<= 9.00){
				printf("</font>");
			}else{
				printf("</font>");
			}
			
			break;
		case 'YEAR':
			printf("%s\n", $data);
			break;
	}
}

$parser = xml_parser_create();
xml_set_element_handler($parser, 'start_element', 'end_element');
xml_set_character_data_handler($parser, 'char_handler');

printf("<div><h1><center>CD Album Report</center></h1></div>");
$fp = fopen('cdcatalog.xml', 'r') or die ("cannot open cdcatalog.xml");
	while ($data = fread($fp, 4096)) {
		xml_parse($parser, $data, feof($fp))
			or die(sprintf('XML ERROR: %s at line %d',
						xml_error_string(xml_get_error_code($parser)),
						xml_get_current_line_number($parser)));
	}
?>
