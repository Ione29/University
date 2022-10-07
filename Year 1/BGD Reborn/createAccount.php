<?php
    session_start();
    
    $dbconnect = mysqli_connect('localhost', 'siteAdmin', 'admin');
    if($dbconnect->connect_error)
    {
        echo "Could not connect to the database";
        die();
    }
    
    $_SESSION['username'] = $_POST['username'];
    $username = $_SESSION['username'];

    mysqli_select_db($dbconnect, 'site');

    $query = "CREATE TABLE IF NOT EXISTS $username(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(50),
                    price INT(200),
                    status VARCHAR(5)
                    );";

    $createtable = mysqli_query($dbconnect, $query);

    header("Location:index.php");
?>