<?php
	session_start();

	include 'functions.php';

?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>

	<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<div class="container">
		<p>Name: <?php echo $_SESSION['name']; ?></p>
		<p>Correct: <?php echo $_SESSION['correct']; ?></p>
		<p>Wrong: <?php echo $_SESSION['wrong']; ?></p>

		<a href="example3.php">Again</a>
	</div>	
</body>
</html>