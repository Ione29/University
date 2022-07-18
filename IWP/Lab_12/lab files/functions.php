<?php

	function sum($a, $b) {
		return $a + $b;
	}

	function question() {
		$a = rand(0, 50);
		$b = rand(0, 50);
		$sum = sum($a, $b);

		echo "{$a} + {$b} = <br><br>";

		$form = "<input type = 'text' name ='answer'>";
		$form .= "<input type = 'hidden' name = 'check' value = '{$sum}'>";
		$form .= " <br><br>";
		
		echo $form;
	}
?>