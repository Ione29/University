<?php
    function countChar($phrase, $letter)
    {
        $count = 0; 
        

        for($i = 0; $i < strlen($phrase); $i++)
        {
            $char = substr($phrase, $i, 1);

            if($letter == strtolower($char) or $letter == $char)
                $count++;
        }

        return $count;

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

    $text = "A JavaScript function is a block of code designed to perform a particular task";
    echo "<br>" . countChar($text, 'a');
    echo "<br>" . countChar($text, 'b');
    echo "<br>" . countChar($text, 's');
    echo "<br>" . countChar($text, 'j');

    ?>

</body>
</html>