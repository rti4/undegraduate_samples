#!/usr/local/bin/perl

#indicates that we are in the body of the email
sub setBody{
	$isbody = 1;
	print "initial that im in body: $input\n";
}

#checks to make sure the main has not already been added
sub oktoadd(){
	print "attempting to add domain\n";
	chomp @split_b[0];
	my $oktoadd =1;

	#checks for duplicates if found oktoadd = false
	foreach $elem(@domain_array){
		if($elem eq @split_b[0]){
			$oktoadd =0;
		}
	}
			
	#adds if duplicate string is not found
	if($oktoadd){
		push(@domain_array, @split_b[0]); 
	}else{
		#print "failed to add: @split_b[0]\n";
	}
}

#extracts the domain from the line
sub domain_search(){
	print "domain search: $input\n";
	my $www="http://www.";
	my $no_www= "http://";

	#removes everything that preceeds the domain name
	if($input =~ /$www/){
		#print "cotains http:www\n";
		@split_a = split(/$www/, $input);
	}else{
		@split_a = split(/$no_www/, $input);

	}

	

	#$i=0;
#foreach $a(@split_a){
#		print "$i: $a\n";
#		$i++;
#	}


	#separates the domain name from what follows it
	#requires the domain name to end with .net, .org, or .com

	foreach $element(@split_a){
		if($element =~ m/(\.com)/){
			print "$element\n";
			@split_b= split(/(?<=com).+/,$element);
			oktoadd();
		}elsif( $element =~ m/(\.net)/){
			print "$element\n";
			@split_b= split(/(?<=net).+/,$element);
			oktoadd();
		}elsif($element =~m/(\.org)/){
			print "$element\n";
			@split_b= split(/(?<=org).+/,$element);
			oktoadd();
		}else{
			print "error! unknown domain: $element\n";
		}
	}

}

sub ip_search{
	@split_a = split(/[\(|\[]/,$input);
	
	foreach $element(@split_a){
		if($element =~ m/\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}/){
			#	print "split this\n";
			@split_b = split(/[\)|\]]/,$element);
			foreach $elem(@split_b){
				if($elem =~ m/^\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}$/){
					#print "found ip address: $elem\n";
					push(@ip_array,$elem);
				}
			}
		}
	}
}


##main function

$input = 0;
$i =0;
@ip_array;
@domain_array;
$isbody = 0;
@split_a;
@split_b;
while($input = <>){
	
	#check to see if a line begins with received
	#2nd if checks to make sure it cotains an ip format string
	if($input =~ m/^Received:/){
		if($input =~ m/\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}/){
			ip_search();
		}
	}elsif ($input =~ m/^\s+$/){ #determines if we are in the body
		if($isbody ==0){
			setBody(); 
		}
	}else{
		#if we are in the body then checks if $input contains a URL
		if(($isbody == 1) &&($input =~ m/http:\/\// )){
			domain_search();
		}
	}

}

#prints out all ip addresses found in the header
#of the email

print "List of IP addresss:\n";
$i=0;
foreach $ip_addr(@ip_array){
	print "$i: $ip_addr\n";
	$i++;
}


print "\n\nList of Domains in Body:\n";
$i=0;
foreach $b(@domain_array){
	print "$i: $b\n";
	$i++;
}
