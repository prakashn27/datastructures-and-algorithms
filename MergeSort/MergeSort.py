
class Solution(object):
    def mergeSort(self, nums):
        half = len(nums) / 2
        if half:
            left, right = self.mergeSort(nums[:half]), self.mergeSort(nums[half:])
            for i in range(len(nums))[::-1]:
                if not right or left and left[-1] > right[-1]:
                    nums[i] = left.pop()
                else:
                    nums[i] = right.pop()
        return nums

pgm = Solution()
nums = [5,2,6,1]
print("mergesort", pgm.mergeSort(nums))
