<?php

  $username = $_POST['username'];
  $password = $_POST['password'];
  $address = $_POST['address'];
  $interests = $_POST['interests'];
  $black = $_POST['black'];
  $white = $_POST['white'];
  $insert = false;

  try {
      $host = 'ec2-54-78-38-127.eu-west-1.compute.amazonaws.com';
      $dbname = "Team6";
      $user = 'root';
      $pass = 'code4good';
      $DBH = new PDO("mysql:host=$host; dbname=$dbname", $user, $pass);
      $DBH->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  } catch (PDOException $e) {
      echo 'Error connecting to database.';
//      file_put_contents('PDOErrors.txt', $e->getMessage(), FILE_APPEND);
  }

  try {
      $STH = $DBH->prepare("INSERT INTO `volunteer` (`Username`, `Password`, `Address`, `Interests`, `Date`, `Black`, `White`) VALUES (:Username, :Password, :Address, :Interests, :Date, :Black, :White)");
      $STH->bindParam(':Username', $username);
      $STH->bindParam(':Password', $password);
      $STH->bindParam(':Address', $address);
      $STH->bindParam(':Interests', $interests);
      $STH->bindParam(':Date', $date);
      $STH->bindParam(':Black', $black);
      $STH->bindParam(':White', $white);

      $username = $_POST['username'];
      $password = $_POST['password'];
      $address = $_POST['address'];
      $interests = $_POST['interests'];
      $white = $_POST['white'];
      $black = $_POST['black'];
      $date = gmdate("Y-m-d H:i:s");

      if($STH->execute())
      {
        $insert = true;
      }

  } catch (PDOException $e) {
        echo "Error submitting info to database";
        echo $e->getMessage();
        exit;
  }

  if($insert)
  {
    echo 'Success! Thanks for registering';
  }