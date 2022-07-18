<?php
	session_start();
	$_SESSION['name'] = '';
	$_SESSION['correct'] = 0;
	$_SESSION['wrong'] = 0;
	$_SESSION['count'] = 0;

	// go to test.php
	if(isset($_POST['name']))
	{
		$_SESSION['name'] = $_POST['name'];
		header('Location: test.php');
	}
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
		<form action="" method="POST">
			<input type="text" name="name" placeholder="name"> <br><br>
			<input type="submit" value="Start">
		</form>
	</div>		

</body>
</html>