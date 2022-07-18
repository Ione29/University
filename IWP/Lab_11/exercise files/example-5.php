<?php
	$arr = [
			['Name', 'Age'],
			['John', '21'],
			['Jane', '19'],
			['Tom', '11'],
		];

	function displayTable($arr)
	{
		$table = "<table>";

		for($i = 0; $i < count($arr); $i++)
		{
			$table .= "<tr>";

			for($j = 0; $j < count($arr[$i]); $j++)
				$table .= "<td>" . $arr[$i][$j] . "</td>";

			$table .= "</tr>";


		}

		$table .= "</table>";

		return $table;
	}
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>

	<style>
		table,
		td,
		tr {
			border: 1px solid black;
			padding: 5px;
			text-align: center;
			border-collapse: collapse;
			font-size: 20px;
			cursor: pointer;
		}
	</style>

</head>
<body>

	<?php

	?>

</body>
</html>