<?php

	$text = "Hello, FILS LAB";
	
	//strlen — Get string length
	//int strlen ( string $string )
	$length = strlen($text);
	echo $length;

	//str_word_count — Counts the number of words inside string
	//str_word_count ( string $string )
	echo '<br>';
	$cw = str_word_count($text);
	echo $cw;

	//strrev — Reverse a string
	//string strrev ( string $string )
	echo '<br>';
	$reverse = strrev($text);
	echo $reverse;

	//str_replace — Replace all occurrences of the search string with the replacement string
	//mixed str_replace ( mixed $search , mixed $replace , mixed $subject )
	echo '<br>';
	$replace = str_replace('Hello', 'Hy', $text);
	echo $replace;

	//strtoupper — Make a string uppercase
	//string strtoupper ( string $string )
	echo '<br>';
	$upp = strtoupper($text);
	echo $upp;

	//strtolower — Make a string lowercase
	//string strtolower ( string $string )
	echo '<br>';
	$low = strtolower($text);
	echo $low;

	//substr — Return part of a string
	//string substr ( string $string , int $start [, int $length ] )
	echo '<br>';
	$uppw = ucwords(strtolower($text));
	echo $uppw;

	//ucfirst — Make a string's first character uppercase
	//string ucfirst ( string $str )
	echo '<br>';
	$uppf = ucfirst(strtolower($text));
	echo $uppf;

	//ucwords — Uppercase the first character of each word in a string
	//string ucwords ( string $str )
	echo '<br>';
	$newText = ". Have a nice year.";
	echo $text . $newText;