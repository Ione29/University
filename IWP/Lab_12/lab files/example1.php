<?php
	$country = [
		'England' => 'England is a country that is part of the United Kingdom.[5][6][7] It shares land borders with Scotland to the north and Wales to the west. The Irish Sea lies northwest of England and the Celtic Sea lies to the southwest. England is separated from continental Europe by the North Sea to the east and the English Channel to the south. The country covers five-eighths of the island of Great Britain (which lies in the North Atlantic) in its centre and south; and includes over 100 smaller islands such as the Isles of Scilly, and the Isle of Wight.',
		'France' => 'France officially the French Republic (République française [ʁepyblik fʁɑ̃sɛz]), is a country with territory in western Europe and several overseas regions and territories.[XV] The European, or metropolitan, area of France extends from the Mediterranean Sea to the English Channel and the North Sea, and from the Rhine to the Atlantic Ocean. Overseas France include French Guiana on the South American continent and several island territories in the Atlantic, Pacific and Indian oceans. France spans 643,801 square kilometres (248,573 sq mi) and had a total population of over 67 million people as of April 2017',
		'Germany' => 'Germany officially the Federal Republic of Germany (German: Bundesrepublik Deutschland, About this sound listen is a federal parliamentary republic in central-western Europe. It includes 16 constituent states, covers an area of 357,021 square kilometres (137,847 sq mi), and has a largely temperate seasonal climate. With about 82 million inhabitants, Germany is the most populous member state of the European Union. After the United States, it is the second most popular immigration destination in the world',
	];

	$display = "";
	$option ="";

	if(isset($_GET['country']))
	{
		$option = $_GET['country'];

		if(isset($country[$option]))
			$display = $country[$option];
		else
			$display = "Country NOT found!";
	}
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>$_GET</title>

	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	
	<div class="container2">	
		<form action="" method="GET">
			<select name="country" id="">
				<option value="England">England</option>	
				<option value="France">France</option>	
				<option value="Germany">Germany</option>			
			</select>
			<input type="submit" value="Search">
		</form>

		<br><hr>

		<h2><?php echo $option; ?></h2>
		<p><?php echo $display; ?></p>
	</div>

</body>
</html>