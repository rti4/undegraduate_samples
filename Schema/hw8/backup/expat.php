<?php
$type_stack = array(); 
$value = 0;
$num_cds = 0;
$name = "";

function start_element($parser, $element_name, $element_attrs) {
  global $type_stack;
  global $value;
  global $num_cds;
  global $name;
  switch ($element_name) {
    case 'CATALOG':
	printf("%-25s %s\n", "Artist", "Avg. Price");
	break;
    case 'ARTIST':
	$value = 0;
	$num_cds = 0;
	$name = "";
	break;
  }
  array_push($type_stack, $element_name);
}

function end_element($parser, $element_name) {
  global $type_stack;
  global $value;
  global $num_cds;
  $type = array_pop($type_stack);
  switch($type) {
    case 'ARTIST':
      printf(" %6.2f\n", $value / $num_cds);
      break;
  }
}

function char_handler($parser, $data) {
  global $type_stack;
  global $num_cds;
  global $value;
  global $name;
  switch(end($type_stack)) {
    case 'PRICE':
      $num_cds++;
      $value += $data;
      break;
    case 'FIRST':
      $name = $data;
      break;
    case 'LAST':
      $name = $data . ", " . $name;
      printf("%-25s", substr($name, 0, 25));
  }
}

$parser = xml_parser_create();
xml_set_element_handler($parser, 'start_element', 'end_element');
xml_set_character_data_handler($parser, 'char_handler');

$fp = fopen('cd2catalog.xml', 'r') or die ("cannot open cd2catalog.xml");
while ($data = fread($fp, 4096)) {
  xml_parse($parser, $data, feof($fp))
	or die(sprintf('XML ERROR: %s at line %d',
	  xml_error_string(xml_get_error_code($parser)),
	  xml_get_current_line_number($parser)));
}
?>
