<?php
?>
    <p>Fill in the details of the game:</p>
    <form action = "addData.php" method = "POST">
     Name of the game: <input type="text" name="name"><br>
     Price of the game (in US$): <input type="number" name="price" min="0" max="200"><br>
     Do you already own the game or do you want it ?<br>
     <input type="radio" name="status" value="Own"> Already Own <br>
     <input type="radio" name="status" value="Want"> Want <br><br>
     <input type="submit" value="submit">
    </form>

