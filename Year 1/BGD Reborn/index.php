<?php 
    session_start();
?>

<!DOCTYPE html>
<html lang="en" id="top">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page</title>

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>

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
                        <form action="search.php" method="POST">
                            <input type="text" placeholder="Type a username" class = "search_box" name="username">
                            <input type="submit" value="Search User">
                        </form>
                    </p>
                </div>
            
            </div>
        </div>
    </div>

    <div class="slideshow">
        <img class = "carousel" src="photos/carousel/image1.jpg" alt="">
        <img class = "carousel" src="photos/carousel/image2.jpg" alt="">
        <img class = "carousel" src="photos/carousel/image3.jpg" alt="">
        <img class = "carousel" src="photos/carousel/image4.jpg" alt="">

        <script>
            var slideIndex = 0;
            carousel();
    
            function carousel()
            {
                var i;
                var x = document.getElementsByClassName("carousel");
                
                for (i = 0; i < x.length; i++) 
                    x[i].style.display = "none";
    
                slideIndex++;
    
                if (slideIndex > x.length) 
                    slideIndex = 1;
    
                x[slideIndex-1].style.display = "block";
                
                setTimeout(carousel, 4000);
            }
        </script>

        <div class = "center_box">
            <div class="center_box_text">
                <p>Welcome to BGD: <strong>the</strong> Board Game Database!</p>
                <ul>
                    <li>Save the games that interest you!</li>
                    <li>Search other user's games!</li>
                    <li>Evaluate your collection!</li>
                </ul>    
            </div>
        </div>
    </div>

    <div class="recruitment">
        <p style="color: black">What are you waiting for ?</p>
        <form action="login.php" class ="recruitment_form">
            <input type="submit" class = "btn" value="Join us!">
        </form>
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

    <script>
        let button=document.getElementsByClassName("backToTop");
        
        function getToTop()
        {
            document.documentElement.scrollTop = 0;
        }
    </script>

</body>
</html>