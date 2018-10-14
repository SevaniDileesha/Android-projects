<html>
    <head></head>
    <body>
		<form method="post" action="calculate.php">
			<input type="text" name="in">
			<input type="submit" name="submit" value="calculate"> 
		</form>
    </body>
</html>

<?php
	$temp = $_POST['in'];
	$values = explode(" ", $temp);

	$y = (2 * $values[2] - $values[1]) / 4;
	$x = ($values[1] - 2 * $values[0] + 2 * $y) / 2;
	$z = ($values[0] - $y) / 6;

	if ($x < 0 or (int($x) != $x)){
		echo "Error";
	}else if( $y < 0 or (int($y) != $y)){
		echo "Error";
	}else if ($z < 0 or (int($z) != $z)){
		echo "Error";
	}else{
		echo $x;
		echo $y;
		echo $z;
	}
?>