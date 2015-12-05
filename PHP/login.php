<?php
session_start();

$host = "ec2-54-78-38-127.eu-west-1.compute.amazonaws.com";
$db_username = "root";
$db_password = "code4good";
$db_name = "Team6";

$username = $_POST['username']; // Sets string username to the text entered in the username field.
$password = $_POST['password']; // Sets $password string to encrypted version of password entered.

// Creates a string that will later be used to connect to the database table.
mysql_connect("$host", "$db_username", "$db_password")
    or die('Database Connection Error1: ' . mysql_error());

// Chooses table and connects using the string set above.
mysql_select_db("$db_name")
    or die("Can't Select DB");

$username = stripslashes($username);
$password = stripslashes($password);
$username = mysql_real_escape_string($username);
$password = mysql_real_escape_string($password);

$sql = "SELECT * FROM Volunteers where Username = '$username' and Password = '$password'";

$result = mysql_query($sql)
    or die ( mysql_error() );

$check = 0;

$check = mysql_num_rows($result);

if ($check == 1) {

    $sql2 = "SELECT * FROM Volenteers ORDER BY time DESC";

    $result = mysql_query($sql2)
        or die("Cannot Select Entries From Table blog".
        "<br />". $sql2 . "<br />". mysql_error());

    $row = mysql_fetch_array($result);

    if ($row == 0)
    {
        header( "Location: addentry.html");
    }
    else {
        header("location: viewBlog.php");
    }

} else {
    echo "Login Error: Incorrect input, try again.";
}
?>
