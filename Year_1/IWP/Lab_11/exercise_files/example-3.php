<?php
    function factorial($n)
    {
        if($n == 1)
            return 1;

        return $n * factorial($n - 1);
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <?php
        echo "<br>" . factorial(6);
    ?>

</body>
</html>