<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>$_POST</title>

	<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<div class="container">	
		<h2>Order pizza online</h2>

		<form class="pizza" action="order.php">

			<input type="text" name="name" placeholder="name">
			<input type="text" name="telephone" placeholder="telephone">
			<select name="pizzaType" id="pizzaType">
				<option value="0" selected="selected"></option>
				<option value="25">Quattro Stagioni</option>
				<option value="24">Quattro Formaggi</option>
				<option value="22">Hawai</option>
				<option value="26">Calzone</option>
				<option value="20">Margherita</option>
			</select>

			Fungi<input type="checkbox" name="topping[]" value="2">
			Feta<input type="checkbox" name="topping[]" value="2">
			Bacon<input type="checkbox" name="topping[]" value="3"><br>

			20 cm<input type="radio" name="size" value="1" checked="checked">
			26 cm<input type="radio" name="size" value="2">
			30 cm<input type="radio" name="size" value="3">

			<input type="text" name="quantity" placeholder="quantity">

			<input type="submit" value="Place Order">
		</form>
	</div>

</body>
</html>