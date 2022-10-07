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
    


    $username = $_SESSION['username'];
    $query = "SELECT * FROM $username";
    $result = mysqli_query($dbconnect, $query) or die("Could not connect to the database.");

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
    <title>Your profile</title>

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
        <h2>These are your registered games:</h2>

        <div class="container">
            <div class="row">
                <div class="col-md-6" id = "table">  <!--Own-->
                    <p><strong>Games that you own</strong></p>
                    <?php echo $stringOwned;?>
                </div>
                <div class="col-md-6" id = "table">  <!--Wish-->
                    <p><strong>Games that you wish for</strong></p>
                    <?php echo $stringWished;?>
                </div>
            </div>
        </div>
    </div>

    <div class="addGames">
        <button id = "showBtn">Add a new Game</button>
        
        <form id="addForm" action = "addData.php" onsubmit ="return fillForm()" style="display:none;">
            <p>
                <label for="name">Name:</label>
                <input type="text" name="name">
            </p>
            <p>
                <label for="price">Price:</label>
                <input type="number" name="price" min="0" max="200">
            </p>
            <p>
                <label for="status">Select the status of the game</label>
                <input type="radio" name="status" value="Own"> Already Own <br>
                <input type="radio" name="status" value="Want"> Want <br><br>
            </p>
            <p>
                <button id = "cancelBtn">Cancel</button>
                <input type="Submit" value="Add a New Game:">
            </p>
        </form>

        <button action = "deleteProfile.php">Delete your profile!</button>
    </div>

    <script>
        let form = document.getElementById("addForm"),
            button = document.getElementById("showBtn"),
            cancel = document.getElementById("cancelBtn");

        function showForm()
        {
            document.getElementById("addForm").style.display = "block";
            button.style.display = "none";
        }

        function hideForm()
        {
            form.style.display = "none";
            button.style.display = "block";
        }

        button.addEventListener("click", showForm);
        cancel.addEventListener("click", hideForm);
    </script>

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