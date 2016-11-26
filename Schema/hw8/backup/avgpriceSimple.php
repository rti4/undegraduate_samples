<?php

$root = simplexml_load_file("cdcatalog.xml");
printf("CD Album Report\n\n");

$key = array();
$array_of_prices = array();
$num_albums = array();
$array_of_names = array();
$sorted_name = array();
$array_of_prices[$index];

$index=0;
/*cycles through all the elements that have a cd tag*/

foreach($root->cd as $album){
	/*then cycles through all the artist*/
	foreach($album->artist as $art){
		$h=0;
		$match=0;

		/*cycles through all the already already processed*/
		foreach($array_of_names as $value){

			/*if the artist is already in the array break out*/
			if(!strcmp($value,$art)){
				$num_albums[$h]++;
				$array_of_prices[$h] += (float)$album->price; 
				$match=1;
				break;
			}

			$h++;
		}
		if($match==0){

			$key[$index] = $index;
			$array_of_prices[$index] = (float)$album->price;
			$num_albums[$index] = 1;
			$array_of_names[$index]=$art;
			$index++;
		}
	}
}

$index=0;

foreach($array_of_names as $v){
	$j= explode(" ", $v, 2);
	if(count($j)>1){
		$sorted_name[$index]=strtolower($j[1]." ".$j[0]);
	}else {
		$sorted_name[$index]=strtolower($v);
	}$index++;
}

sort($sorted_name);

$index=0;

foreach($sorted_name as $v){
	$j= explode(" ", $v, 3);
	if(count($j)==2){
		$sorted_name[$index]=strtolower($j[1]." ".$j[0]);
	}elseif(count($j)==1) {
		$sorted_name[$index]=strtolower($v);
	}else {
		$sorted_name[$index]=strtolower($j[2]." ".$j[0]." ".$j[1]);
	}
	$index++;
}

foreach($sorted_name as $v){
	$index=0;
	foreach($array_of_names as $z){
		$end = (float)($array_of_prices[$index]/$num_albums[$index]);
		if(!strcmp(strtolower($z),strtolower($v))){
			$j= explode(" ", $z, 2);
			if(strcmp($j[1],"")){ printf("%-25s %2.2f\n",$j[1].", ".$j[0],$end);
			}else{ 
				printf("%-25s %2.2f\n",$j[0],$end);
			}
		}
		$index++;
	}
}
?>

