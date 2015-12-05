<?php
  try {
           $host = 'ec2-54-78-38-127.eu-west-1.compute.amazonaws.com';
           $dbname = "Team6";
           $user = 'root';
           $pass = 'code4good';
           $DBH = new PDO("mysql:host=$host; dbname=$dbname", $user, $pass);
           $DBH->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
         } catch (PDOException $e) {
           echo 'Error connecting to database.';
         }


         try{
           $STH = $DBH->prepare("SELECT * FROM volunteer WHERE Volunteer_id='1'");
           $STH->setFetchMode(PDO::FETCH_OBJ);
           $STH->execute();
           if($STH->rowCount() > 0) {
               # showing the results
               while ($row = $STH->fetch()) {
                 $vid = $row->Volunteer_id;
                 $vInterests = $row->Interests;
               }
           }
         } catch (PDOException $e) {
           echo $e->getMessage();
           exit;
         }

         $vInts = implode("%' OR Interests LIKE '%", explode(", ", $vInterests));

         try{
           $STH = $DBH->prepare("SELECT * FROM constituents WHERE Interests LIKE '%$vInts%'");
           $STH->setFetchMode(PDO::FETCH_OBJ);
           $STH->execute();
           if($STH->rowCount() > 0) {
               # showing the results
               while ($row = $STH->fetch()) {
                 $cID[] = $row->Constituents_id;
                 $cName[] = $row->Username;
                 $cInterests[] = $row->Interests;
               }
           }
         } catch (PDOException $e) {
           echo $e->getMessage();
           exit;
         }

         print_r($cName);
//         $array[] = new array('~' => '~');    	//print array($results,$results2);   	//var $jsonArray = ["array" => array($results,$results2)]; 	 	//echo json_encode(array($results,$results2));   	echo json_encode(array_merge($results,$results2));  die();    mysql_close();
?>
