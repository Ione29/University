	<?php
		$arr = array('PHP', 'CSS', 'HTML', 'JavaScript', 'jQuery');
		
		//array_pop — Pop the element off the end of array
		//mixed array_pop ( array &$array )
		array_pop($arr);
		
		//array_shift — Shift an element off the beginning of array
		//mixed array_shift ( array &$array )
		array_shift($arr);

		//array_push — Push one or more elements onto the end of array
		//int array_push ( array &$array , mixed $value )
		array_push($arr, 'last');
		
		//array_unshift — Prepend one or more elements to the beginning of an array
		//int array_unshift ( array &$array , mixed $value )
		array_unshift($arr, 'first');

		
		//shuffle — Shuffle an array
		//bool shuffle ( array &$array )
		//shuffle($arr);
		
		
		//rsort — Sort an array in reverse order
		//bool rsort ( array &$array )
		//rsort($arr);
		
		
		//sort — Sort an array
		//bool sort ( array &$array )
		//sort($arr);

		
		
		foreach ($arr as $language) {
			echo '<li>' . $language . '</li>';
		}

		//array_rand — Pick one or more random entries out of an array
		//mixed array_rand ( array $array )
		echo "Random element " . $arr[array_rand($arr)];
		
		//count — Count all elements in an array, or something in an object
		//int count ( mixed $array_or_countable )
		echo "<br>Total elements " . count($arr);

		//implode — Join array elements with a string
		//string implode ( string $glue , array $pieces )
		$createString = implode(" ... ", $arr);
		echo '<br>' . $createString;

		//explode — Split a string by string, returns an array of strings
		//array explode ( string $delimiter , string $string )
		$string = 'name, username, mail';
		$newArr = explode(',', $string);

		foreach ($newArr as $list) {
			echo '<li>' . $list . '</li>';
		}
	?>