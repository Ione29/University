<?php
    $dbconnect = mysqli_connect('localhost', 'siteAdmin','admin');
    if($dbconnect->connect_error)
        die("Could not connect at the database");
    
    mysqli_select_db($dbconnect, 'site');

    $name = $_POST['name'];
    $price = $_POST['price'];
    $status = $_POST['status'];

    $username = $_SESSION['username'];

    if($status == "Want")
        $query = "INSERT INTO $username (name, price, status) VALUES ('$name', '$price', 'Want')";
    else
        $query = "INSERT INTO $username (name, price, status) VALUES ('$name', '$price', 'Own')";

    $add = mysqli_query($dbconnect, $query)
        or die("Error: Could not add game to the database.");

    header("Location: profile.php");
?>