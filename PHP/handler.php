<?php
  $name = $_REQUEST['name'];
  $email = $_REQUEST['email'];
  $phone = $_REQUEST['phone'];
  $likes = $_REQUEST['likes'];
  $dislikes = $_REQUEST['dislikes'];

  $host = ''
  $dbName = ''
  $username = ''
  $password = ''

  $db = new mysqli($host,$username,$password,$dbName);

  if($db->connect_Errno > 0){
  	die('Could not connect to the database.  Error ' . $db->connect_error);
  }

  $sql = "INSERT INTO 'table'
  		  VALUES ('$name','$email','$phone','$likes','$dislikes')";

if(!$result = $db->query($sql)){
  	die('Error running query: ' . $db->error);
  	return false;
  else{
  	return true;
  }
}


?>
