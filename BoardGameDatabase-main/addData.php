<?php
    session_start();
    ini_set('display_errors', 1);
    error_reporting(E_ALL);

    $dbconnect = mysqli_connect('localhost', 'siteAdmin','admin');
    if($dbconnect->connect_error)
    {
    echo "Could not connect at the database";
    die();
    }

    mysqli_select_db($dbconnect, 'site');

    $name = $_POST['name'];
    $price = intval($_POST['price']);
    $status = $_POST['status'];
    $username = $_SESSION['username'];

    if($status == "Want")
        $query = "INSERT INTO $username (name, price, status) VALUES ('$name', '$price', 'Want')";
    else
        $query = "INSERT INTO $username (name, price, status) VALUES ('$name', '$price', 'Own')";

    $add = mysqli_query($dbconnect, $query)
        or die("Error: Could not add game to the database");

    header("Location: login.php");
?>
