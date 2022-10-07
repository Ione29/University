<?php 
	include 'inc/header.php';
?>


	<section>
		<div class="content">
			<h1>Contact</h1>

			<form action="">
			<p>
				<label for="name">Name</label><br>
				<input type="text" id="name">
			</p>

			<p>
				<label for="mail">Mail</label><br>
				<input type="text" id="mail">
			</p>

			<p>
				<label for="comment">Comment</label><br>
				<textarea name="comment" id="comment" cols="30" rows="10"></textarea>
			</p>

			<p>
				<input type="submit" value="Send" class="button">
			</p>
			</form>
		</div>
	</section>


	<?php 
		include 'inc/footer.php';
	?>

</body>
</html>