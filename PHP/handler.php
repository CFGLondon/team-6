<?php
  $name = $_REQUEST['name'];
  $email = $_REQUEST['email'];
  $phone = $_REQUEST['phone'];
  $likes = $_REQUEST['likes'];
  $dislikes = $_REQUEST['dislikes'];
  $daysArray[] = $_REQUEST['days'];  //Need to decide how elements will be stored in the database

  $host = 'ec2-54-78-38-127.eu-west-1.compute.amazonaws.com'
  $username = 'ubuntu'
  $password = 'code4good'

  $db = new mysqli($host,$username,$password);

  if($db->connect_Errno > 0){
  	die('Could not connect to the database.  Error ' . $db->connect_error);
  }

  $implodedDays = implode(', ', $daysArray);

  $sql = "INSERT INTO 'table' VALUES ($name,$email,$phone,$likes,$dislikes,$implodedDays)";

if(!$result = $db->query($sql)){
  	die('Error running query: ' . $db->error);
  	return false;
  }
else{
  	return true;
  }