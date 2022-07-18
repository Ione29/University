// charAt(index)
// charCodeAt(index)
var str = "JavaScript";

console.log(str.charAt(0) + " " + str.charAt(4));
console.log(str.charCodeAt(0) + " " + str.charCodeAt(4));

for (var i = 0; i < str.length; i++) {
	console.log(str.charAt(i));
}


// concat(string2[,string3,...,stringN])
var str1 = "Java", 
	str2 = "Script",
	str3 = "Hello",
	str4 = " ";
console.log(str1.concat(str2));	
console.log(str3.concat(str1, str2));
var newStr = str3.concat(str4, str1, str2);
console.log(newStr);


// includes(searchString[,position])
console.log(newStr.includes(str));
console.log(newStr.includes("PHP"));


// endsWith(searchString[,length])
// startsWith(searchString[, position])
console.log(newStr.endsWith(str));
console.log(newStr.endsWith("PHP"));
console.log(newStr.startsWith(str));
console.log(newStr.startsWith("Hello"));


// indexOf(searchValue[,fromIndex])
// lastIndexOf(searchValue[,fromIndex])
var phrase = "Hello JavaScript. Hallo JavaScript. Bonjour JavaScript";
console.log(phrase.indexOf(str));
console.log(phrase.lastIndexOf(str));
console.log(phrase.lastIndexOf("PHP"));


// repeat(count)
console.log(str.repeat(3));


// replace(substr,function)
console.log(phrase.replace("JavaScript" ,"JS"));


// slice(beginIndex[,endIndex])
console.log(str.slice(4));
console.log(str.slice(0, 4));
console.log(str.slice(4, 10));


// split([separator[,limit]])
console.log(phrase.split(" "));
console.log(phrase.split(" ", 2));


// substr(start[,length])
console.log(str.substr(4));
console.log(str.substr(4, 2));


// substring(indexStart[,indexEnd])
console.log(str.substring(4));
console.log(str.substring(4, 6));


// toLowerCase()
console.log(str.toLowerCase());


// toUpperCase()
console.log(str.toUpperCase());


// trim()
console.log("  JavaScript  ");
console.log("  JavaScript  ".trim());