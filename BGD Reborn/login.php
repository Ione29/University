<?php
    session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body >
    
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
                        <form action="search.php" method ="POST">
                            <input type="text" placeholder="Type a username" class = "search_box" name="username">
                            <input type="submit" value="Search User">
                        </form>
                    </p>
                </div>
            
            </div>
        </div>
    </div>

    <div class="login">
        <form class = "form" onsubmit = "return validateForm()" action="createAccount.php" method="POST">
            <p>Please type in your name. In case you are new, a new profile will be created for you automatically.</p>
            <p>
                <label for="username">Username:</label>
                <input type="text" name="username" id="username">
                <p class="invalid" id="msgUsername"></p>
            </p>
            <p>
                <input type="submit" value="Log In">
            </p>
        </form>    
    </div> 

    <script>
        function validateForm() {
            let username = document.getElementById('username').value,
                msgUsername = document.getElementById('msgUsername'),
                valid = true;
            
            if(!username.length)
            {
                msgUsername.innerHTML = "This field cannot be empty.";
                valid = false;
            }
            else if(username.length < 3)
            {
                msgUsername.innerHTML = "Username has to be at least 3 letters long";
                valid = false;
            }
            else 
                msgUsername.innerHTML = '';
            
            if (valid == true) 
                return true;
            
            return false;
            
        }
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
