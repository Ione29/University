<?php
	session_start();

	include 'functions.php';

	if($_SESSION['count'] == 5)
		header("Location: results.php");

	if(isset($_POST['answer']))
	{
		$answer = $_POST['answer'];
		$check = $_POST['check'];
		$_SESSION['count']++;
	
		if($answer == $check)
			$_SESSION['correct']++;
		else
			$_SESSION['wrong']++;
	}

	header("Location: test.php");
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
		<form method='POST' action=''>
			<?php question(); ?>
			<input type="submit" value="Answer">
		</form>

		<p>Name: <?= $_SESSION['name']; ?></p>
		<p>Correct: <?= $_SESSION['correct']; ?></p>
		<p>Wrong: <?= $_SESSION['wrong']; ?></p>
	</div>	

</body>
</html>