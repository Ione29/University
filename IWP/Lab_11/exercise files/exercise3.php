<?php
    function sum($n)
    {
        $sum = 0;

        for($i = 1; $i <= $n; $i++)
            $sum += pow($i, $i);

        return $sum;
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

    echo "<br>" . sum(1);
    echo "<br>" . sum(2);
    echo "<br>" . sum(3);
    
    ?>

</body>
</html>