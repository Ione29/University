<?php
    if(isset($_POST['name']))
    {
        $name = $_POST['name'];
        setcookie('name', $name, time() * 60 * 60);
    }

    if(isset($_POST['telephone']))
    {
        $telephone = $_POST['telephone'];
        setcookie('telephone', $telephone, time() * 60 * 60);
    }

    if(isset($_POST['cupType']))
    {
        $cupType = $_POST['cupType'];
        setcookie('cupType', $cupType, time() * 60 * 60);
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	
	<h2>Order data</h2>
	<p>Name: <?php echo $_COOKIE['name']; ?></p>
	<p>Telephone: <?php echo $_COOKIE['telephone']; ?></p>
	<p>Ice Cream: <?php echo $_COOKIE['cupType']; ?></p>

</body>
</html>