<?php
    session_start();
    ini_set('display_errors', 1);
    error_reporting(E_ALL);

    $stringOwned="<table>
                    <tr>
                    <td> ID </td>
                    <td> Name of the Game </td>
                    <td> Price </td>
                    </tr>
                    ";
    
    $stringWished=  "<table>
                    <tr>
                    <td> ID </td>
                    <td> Name of the Game </td>
                    <td> Price </td>
                    </tr>
                    ";

    $dbconnect = mysqli_connect('localhost', 'siteAdmin', 'admin');
    if($dbconnect->connect_error)
    {
        echo "Could not connect to the database";
        die();
    }

    mysqli_select_db($dbconnect, 'site');

    $totalWished = 0;
    $totalOwned = 0;
    $totalPriceOwned = 0;
    $totalPriceWished = 0;
    $absoluteTotal = 0;
    $absolutePrice = 0;

    $username = $_POST['username'];
    $query = "SELECT * FROM $username";
    $result = mysqli_query($dbconnect, $query) or die("Could not find the specified user in our database.");

    while($row = mysqli_fetch_assoc($result))
    {
        if($row['status'] == "Own")
        {
        $totalOwned++;
        $totalPriceOwned = $totalPriceOwned + $row['price'];
        $stringOwned = $stringOwned .   "<tr>
                                <td>{$row['id']}</td>
                                <td>{$row['name']}</td>
                                <td>{$row['price']}</td>
                                </tr>";
        }
        
        if($row['status'] == "Want")
        {
        $totalWished++;
        $totalPriceWished = $totalPriceWished + $row['price'];
        $stringWished = $stringWished .   "<tr>
                                <td>{$row['id']}</td>
                                <td>{$row['name']}</td>
                                <td>{$row['price']}</td>
                                </tr>";
        }

        $absoluteTotal++;
        $absolutePrice = $absolutePrice + $row['price'];
    }

    $stringOwned .= "</table>";
    $stringWished .= "</table>";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?=$_POST['username']?>'s profile</title>

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    
    <div class="top">
        <div class="container">
            <div class="row">

                <div class="col-md-3 logo">
                    <a href="index.php"> <img src="photos/logos/logo.png" class = "logo"> </a>
                </div>

                <div class="col-md-6" id="navigation" style="padding-top: 15px;">
                    <p>
                        <?php
                            if(isset($_SESSION['username'])) : ?>
                            <ul>
                                <li style="font-size:25px; color:black">Welcome back,<a href="profile.php"><?=$_SESSION['username']?></a></li>
                                <li><a href="logout.php">Log Out</a></li>
                            </ul>
                            <?php else: ?>
        
                                <a style="font-size:25px; color:black" href="login.php">Sign Up / Log In</a>
                        <?php endif; ?>
                    </p>
                </div>
                
                <div class="col-md-3">
                    <p>
                        <form action="search.php" method = "POST">
                            <input type="text" placeholder="Type a username" class = "search_box" name="username">
                            <input type="submit" value="Search User">
                        </form>
                    </p>
                </div>
            
            </div>
        </div>
    </div>

    <div class="center">
        <h3>These are the games owned by <?=$_POST['username']?></h3>
        <div class="container">
            <div class="row">
                <div class="col-md-6" id = "table">  <!--Own-->
                    <p><strong>Games that <?=$_POST['username']?> owns</strong></p>
                    <?php echo $stringOwned;?>
                </div>
                <div class="col-md-6" id = "table">  <!--Wish-->
                    <p><strong>Games that <?=$_POST['username']?> wishes for</strong></p>
                    <?php echo $stringWished;?>
                </div>
            </div>
        </div>
    </div>
    </div>
            
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-3" id="btn">
                    <button class="backToTop" onclick="getToTop()"> Back to top </button>
                </div>
                <div class="col-md-6">
                    <ul class="about">
                        <li >Copyright FILS</li>
                        <li >Ionita Alexandru-Mihail</li>
                        <li >2022</li>
                    </ul>
                </div>        
                <div class="col-md-3">
                    <ul class="social">
                        <li> <a href="https://www.github.com/Ione29"> <img src="photos/logos/logo_github.png" alt=""> </a> </li>
                        <li> <a href="http://ing.pub.ro/en/"> <img src="photos/logos/logo_upb.png" alt=""> </a> </li>
                    </ul>
                </div>
            </div>
        </div>    
    </div>

</body>
</html>