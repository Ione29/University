<?php
	
	$name = $_POST['name'];
	$telephone = $_POST['telephone'];
	$pizzaType = $_POST['pizzaType'];
	$topping = $_POST['topping'];
	$size = $_POST['size'];
	$quantity = $_POST['quantity'];

	$toppingPrice = 0;

	for($i = 0; $i < count($topping); $i++)
		$toppingPrice += $topping[$i];

	$price = ($pizzaType * $size + $toppingPrice) * $quantity;

	if($price > 100)
		$discount = $price - $price * 10 / 100;
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	
	<h2>Order data</h2>
	<p>Name: <?php echo $name; ?></p>
	<p>Telephone: <?php $telephone ?></p>
	<p>Topping price <?php echo $toppingPrice ?></p>

	<?php
		if($price < 100):
	?>
		<p>Price: <?php echo $price; ?> </p>
	<?php 
		else:
	?>
		<p>Price:
			<span style = "text-decoration: line-through">
				<?php echo $price; ?>
			</span>
			<?php $discount; ?>
		</p>
	<?php
		endif;
	?>

</body>
</html>