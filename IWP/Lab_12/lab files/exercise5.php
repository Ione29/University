<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="css/styles.css">

</head>
<body>
    
<div class="container">	
		<h2>Order ice cream online</h2>

		<form class="icecream" action="orderIcecream.php" method = "POST">
			<input type="text" name="name" placeholder="name">
            <br>
			<input type="text" name="telephone" placeholder="telephone">
            <br>
            <select name="cupType" id="cupType">
				<option value="Cup" selected="selected">Cup</option>
				<option value="Plain Cone">Plain Cone</option>
				<option value="Sugar Cone">Sugar Cone</option>
				<option value="Waffle Cone">Waffle Cone</option>
			</select>
            <br>
			<input type="submit" value="Place Order">
		</form>
	</div>


</body>
</html>