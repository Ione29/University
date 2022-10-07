<?php
  session_start();
  ini_set('display_errors', 1);
  error_reporting(E_ALL);

  $dbconnect = mysqli_connect('localhost', 'siteAdmin', 'admin');
  if($dbconnect->connect_error)
  {
    echo "Could not connect to the database";
    die();
  }

  if(!(isset($_SESSION['username'])))
   {
      $_SESSION['username'] = $_POST['username'];
      $username = $_SESSION['username'];
   } 

  mysqli_select_db($dbconnect, 'site');

  $query = "CREATE TABLE IF NOT EXISTS $username(
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(50),
                price INT(200),
                status VARCHAR(5)
                );";

  $createtable = mysqli_query($dbconnect, $query);

  echo "<table>
        <tr>
          <td> No. </td>
          <td> Name of the Game </td>
          <td> Price </td>
          <td> Owns </td>
          <td> Wants </td>
        </tr>
        ";

    $totalWished = 0;
    $totalOwned = 0;
    $totalPriceOwned = 0;
    $totalPriceWished = 0;
    $absoluteTotal = 0;
    $absolutePrice = 0;

    $query = "SELECT * FROM $username";
    $result = mysqli_query($dbconnect, $query);

    while($row = mysqli_fetch_array($result))
    {
    echo
      "<tr>
        <td>{$row['id']}</td>
        <td>{$row['name']}</td>
        <td>{$row['price']}</td>
        <td>{$row['status']}</td>
      </tr>
      ";

      if($row['status'] == "Own")
      {
        $totalOwned++;
        $totalPriceOwned = $totalPriceOwned + $row['price'];
      }
      if($row['status'] == "Want")
      {
        $totalWished++;
        $totalPriceWished = $totalPriceWished + $row['price'];
      }

      $absoluteTotal++;
      $absolutePrice = $absolutePrice + $row['price'];
    }
    echo "</table><br>";

    echo "
    <table>
      <tr>
      <td>Number of games owned:</td>
      <td>$totalOwned</td>
      <td>Total price of owned games:</td>
      <td>$totalPriceOwned</td></tr>
      <tr>
      <td>Number of games wanted:</td>
      <td>$totalWished</td>
      <td>Total Price of wanted games</td>
      <td>$totalPriceWished</td></tr>
      <tr>
      <td>Total number of games</td>
      <td>$absoluteTotal</td>
      <td>Total price of the games</td>
      <td>$absolutePrice</td></tr>
      </table>
      <br>
        ";

  ?>
  <br>

  <form action="addEntry.php" mode = "POST">
    <input type="submit" value="Click here to add a game" name = "run">
  </form>
