## Binary Search

#### Assumption
```
array should be ordered, else add nlog n for time complexity
```
#### Algorithm:
```
1. set low = 0, high = len - 1;
2. mid = (low + high) / 2
3. check if arr[mid] == val
	a. if true , return value
	else
		if arr[mid] < val, 
			(our required value is in second half)
			set low = mid + 1; go to step 2
		else , 
			(our value is in first half)
			set high = mid - 1; go to step 2

```

#### Complexity

| Time  | Space |
| ---- | ----- |
| O(log n)  | O(1)  |
