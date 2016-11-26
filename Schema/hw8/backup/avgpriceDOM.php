<?php
$xmlDoc = new DOMDocument();
$xmlDoc->preserveWhiteSpace = false;
$xmlDoc->load("cdcatalog.xml");
$root = $xmlDoc->documentElement;

$index = array();
$array_of_names = array();
$arr_tot_price = array();
$num_albums = array();
$i=0;
$arr_tot_price[$i];

printf("%-25s %s\n", "Artist", "Avg Price");
$albums = $root->getElementsByTagName('cd');

/*identifies when an new album is being processed*/
foreach($albums as $album){
	/*stores the current artist and price being processed*/
	$curr_artists = $album->getElementsByTagName('artist');
	$price_vares = $album->getElementsByTagName('price');


	foreach($price_vares as $price_var){
		$price_vare = $price_var->nodeValue;
	}	
	
	
	foreach($curr_artists as $art){
		$j=0;
		$match=0;
		/*processes through the array of names*/
		foreach($array_of_names as $value){

			/*if there is already a match*/
			if(!strcmp($value,$art->nodeValue)){
				printf("duplicate found\n");
				$num_albums[$j]++;
				$arr_tot_price[$j] = $arr_tot_price[$j] + (float)$price_vare; 
				$match=1;
				/*no need to keep processing*/
				break;
			}
			$j++;
		}
		if($match==0){
			$index[$i] = $i;
			$arr_tot_price[$i] = (float)$price_vare;
			$num_albums[$i] = 1;
			$array_of_names[$i]=$art->nodeValue;
			$i++;
		}

	}
}

$i=0;
$sorted_name = array();
foreach($array_of_names as $v){
	$a= explode(" ", $v, 2);
	if(count($a)>1){
		$sorted_name[$i]=strtolower($a[1]." ".$a[0]);
	}else {
		$sorted_name[$i]=strtolower($v);
	}
	$i++;
}

sort($sorted_name);
$i=0;

foreach($sorted_name as $v){
	$a= explode(" ", $v, 3);
	if(count($a)==2){
		$sorted_name[$i]=strtolower($a[1]." ".$a[0]);
	}elseif(count($a)==1) {
		$sorted_name[$i]=strtolower($v);
	}else {
		$sorted_name[$i]=strtolower($a[2]." ".$a[0]." ".$a[1]);
	}
	$i++;
}

foreach($sorted_name as $v){
	$i=0;
	foreach($array_of_names as $z){
		$final = (float)($arr_tot_price[$i]/$num_albums[$i]);
		if(!strcmp(strtolower($z),strtolower($v))){
			$a= explode(" ", $z, 2);
			if(strcmp($a[1],"")){ printf("%-25s %2.2f\n",$a[1].", ".$a[0],$final);
			}
			else{ 
				printf("%-25s %2.2f\n",$a[0],$final);
			}
		}
		$i++;
	}
}
?>
