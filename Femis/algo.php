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

         $volunteer = is_numeric($_GET['volunteer']) ? $_GET['volunteer'] : 1;

         try{
           $STH = $DBH->prepare("SELECT * FROM volunteer WHERE Volunteer_id='$volunteer'");
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
//         $array[] = new array('~' => '~');    	//print array($results,$results2);   	//var $jsonArray = ["array" => array($results,$results2)]; 	 	//echo json_encode(array($results,$results2));   	echo json_encode(array_merge($results,$results2));  die();    mysql_close();
?>

<!DOCTYPE html>
  <head>
    <title>Matcher</title>
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<meta name="description" content="" />
				<meta name="keywords" content="" />
				<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400" rel="stylesheet" />
					<script src="js/jquery-1.9.1.min.js"></script>
					<script src="css/5grid/init.js?use=mobile,desktop"></script>
					<script src="js/jquery.formerize-1.1.js"></script>
					<script src="js/init.js"></script>
				<noscript>
					<link rel="stylesheet" href="css/5grid/core.css" />
					<link rel="stylesheet" href="css/5grid/core-desktop.css" />
					<link rel="stylesheet" href="css/5grid/core-1200px.css" />
					<link rel="stylesheet" href="css/5grid/core-noscript.css" />
					<link rel="stylesheet" href="css/style.css" />
					<link rel="stylesheet" href="css/style-desktop.css" />
					<link rel="stylesheet" href="css/noscript.css" />
				</noscript>

				<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

				<!-- jQuery library -->
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

				<!-- Latest compiled JavaScript -->
				<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body class="homepage">

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">

						<a href="#login" class="icon icon-user active"><span>Login</span></a>

					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="me" class="panel">
								<header>
									<h1>Team 4 + 2</h1>
									<span class="byline">Age UK</span>
								</header>
								<a href="#login" class="jumplink pic">
									<span class="jumplink arrow icon icon-right"></span>
									<img src="images/age.png"  alt=""/>
								</a>
							</article>



						<!-- Login -->
							<article id="login" class="panel">
								<header>
									    <h2>Matcher</h2>
								</header>






<?php
  for($i = 0; i < count($cName); $i++)
  {
    ?>
    <div id = container>
      <div class = "jumbotron row">
        <div class = "col-xs-3">
          <h2>Name</h2>

      <p><?php echo $cName[$i]; ?></p>
      </div>
      <div class = "col-xs-6">
        <h2>Hobbies</h2>
    <p><?php echo $cInterests[$i]; ?></p>
    </div>
    <div class = "col-xs-3">
      <h2>Match level</h2>
  <p class = "text-success"> 98% </p>
  </div>
    </div>

    <?php
  }
 ?>

    </div>


							</article>

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="links">
							<li>&copy; Team 4+ 2</li>


						</ul>
					</div>

			</div>

	</body>
</html>
