<?php
$root = simplexml_load_file("cd2catalog.xml");

// print the report header
printf("%-25s %s\n", "Artist", "Avg Price");

// process the artist elements
foreach ($root->artist as $artist) {
  // get the cds associated with this artist and compute their average price
  $value = 0;
  $num_cds = 0;
  foreach ($artist->cd as $cd) {
    $value += (double)$cd->price;
    $num_cds++;
  }
  // create a properly formatted name: lastname, firstname
  $formatted_name = $artist->name->last . ", " . $artist->name->first;
  printf("%-25s %6.2f\n", substr($formatted_name, 0, 25), $value / $num_cds);
}
?>
