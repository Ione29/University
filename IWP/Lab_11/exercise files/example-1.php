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
    function sumDigits($n)
    {
        $sum = 0;
    
        while($n > 0)
        {
            $sum += $n % 10;
            $n = intval($n / 10);
        }
    
        return $sum;
    }

    echo "<br>" . sumDigits(123);
    echo "<br>" . sumDigits(12301);
    echo "<br>" . sumDigits(54321);
    ?>

</body>
</html>

