'using strict';

function binarySearch(arr, target) {
	if(arr.length === 0) return false;

	let low = 0, high = arr.length - 1;
	while(low <= high) {
		let mid = Math.round((low + high) / 2);
		if(arr[mid] === target) return true;
		else if(arr[mid] > target) high = mid - 1;
		else low = mid	+ 1;
	}
	return false;
}

let arr = [1, 2, 3, 4, 5];
console.log(binarySearch(arr, 1));