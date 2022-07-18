<?php
    function deleteElement($arr, $element)
    {
        $index = array_search($element, $arr);

        if($index)
            array_splice($arr, $index, 1);

        return $arr;
    }    

    function display($arr)
    {
        for($i = 0; $i < count($arr); $i++)
            echo $arr[$i] . " ";

        echo "<br>";
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

    $arrTest = [5, 7, 1, 4, 8];

    display(deleteElement($arrTest, 4));
    display(deleteElement($arrTest, 9));
    display(deleteElement($arrTest, 7));

    ?>

</body>
</html>