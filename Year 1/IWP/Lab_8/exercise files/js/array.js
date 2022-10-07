// copyWithin(target[, start[, end]])
var arr = ["JS", "PHP", "CSS", "HTML"];
console.log(arr.copyWithin(2, 0));


// fill(value[, start[, end]])
console.log(arr.fill("FILS"));


// pop()
var nombre = [4, 5, 1, 6];
nombre.pop();
console.log(nombre);


// push(element1[, ...[, elementN]])
nombre.push(2)
console.log(nombre);
nombre.push(8, 3)
console.log(nombre);


// shift()
nombre.shift();
console.log(nombre);


// unshift(element1[, ...[, elementN]])
nombre.unshift(9)
console.log(nombre);
nombre.unshift(1, 6)
console.log(nombre);


// sort([compareFunction])
var sort = nombre.sort();
console.log(sort);


// reverse()
console.log(nombre.reverse());


// concat(value1[, value2[, ...[, valueN]]])
console.log(sort.concat(nombre));


// includes(searchElement[, fromIndex])
console.log(nombre.includes(2));
console.log(nombre.includes(7));
console.log(nombre.includes(2, 5));
console.log(nombre.includes(2, 1));


// indexOf(searchElement[, fromIndex])
console.log(nombre);
console.log(nombre.indexOf(5));
console.log(nombre.indexOf(9));
console.log(nombre.indexOf(9, 4));


// lastIndexOf(searchElement[, fromIndex])
console.log(nombre.lastIndexOf(4));
console.log(nombre.lastIndexOf(5));
console.log(nombre.lastIndexOf(5, 4));


// join([separator])
console.log(nombre.join());
console.log(nombre.join("-x-"));


// slice([begin[, end]])
console.log(nombre.slice(3));
console.log(nombre.slice(3, 5));