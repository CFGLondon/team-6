<?php
$host = "ec2-54-78-38-127.eu-west-1.compute.amazonaws.com";
$db_username = "root";
$db_password = "code4good";
$db_name = "Team6";

//Tell script what to do if submit button is pressed
if (isset($_POST['submit']))
{
    $month = htmlspecialchars(strip_tags($_POST['month']));
    $date = htmlspecialchars(strip_tags($_POST['date']));
    $year = htmlspecialchars(strip_tags($_POST['year']));
    $time = htmlspecialchars(strip_tags(date("H:i")));
    $title = htmlspecialchars(strip_tags($_POST['title']));

    $body = $_POST['body'];

    //string-to-timestamp function takes regular date (string) turns into timestamp
    $timestamp = strtotime($month . " " . $date . " " . $year . " " . $time);

    $body = nl2br($body); //Automatically add line breaks to $body

    //Detects if server will automatically escape quotes submitted to database
    if (!get_magic_quotes_gpc())
    {
        $title = addslashes($title);
        $body = addslashes($body);
    }

    mysql_connect("$host", "$db_username", "$db_password")
        or die("Cannot Connect to Database". mysql_error() );

    mysql_select_db("$db_name")
        or die("Cannot Select Database". $db_name);

    $sql = "INSERT INTO $tbl_name (time,title,body) VALUES ('$timestamp','$title','$body')";

    $result = mysql_query($sql)
        or die("Cannot insert table".$tbl_name.".<br />".$sql."<br />".mysql_error());

    if ($result != false)
    {
        echo "Your body has been successfully entered into the database!";
        //header( "Location: viewBlog.php" );
    }

    mysql_close();
}

?>
