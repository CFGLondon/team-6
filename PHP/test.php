<?php

$var = "Coding, Running, Sleeping, Dance, Dancing";

$newVar = implode(" OR Interests LIKE ", explode(", ", $var));

echo $newVar;
