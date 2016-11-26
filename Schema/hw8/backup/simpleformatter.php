<?php

$root = simplexml_load_file("cdcatalog.xml");
printf("<h1> <center>CD Album Report </center></h1>\n");

foreach($root->cd as $album){
	printf("<hr/>");
	printf("<div><h3>%s</h3></div>\n", $album->title);
	printf("<ul>");
	foreach($album->artist as $artist){
		printf("<li>%s</li>\n", $artist);
	}
	
	if($album->price >9.00){
		printf("<li><font color=green>%s </font></li>", $album->price);
	}else{
		printf("<li><font color=blue> %s </font></li>", $album->price);
	}
	
	printf("<li>%s</li>", $album->year);
	printf("</ul>\n");
}



?>
