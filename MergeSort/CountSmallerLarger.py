
class Solution(object):
    def countSmaller(self, nums):
        def sort(enum):
            half = len(enum) / 2
            if half:
                left, right = sort(enum[:half]), sort(enum[half:])
                for i in range(len(enum))[::-1]:
                    if not right or left and left[-1][1] > right[-1][1]:
                        smaller[left[-1][0]] += len(right)
                        enum[i] = left.pop()
                    else:
                        enum[i] = right.pop()
            # print(enum, smaller)
            return enum
        smaller = [0] * len(nums)
        sort(list(enumerate(nums)))
        return smaller

    def countLarger(self, nums):
        def sortlarge(enum):
            half = len(enum) / 2
            if half:
                left, right = sortlarge(enum[:half]), sortlarge(enum[half:])
                for i in range(len(enum)):
                    if not right or left and right[0][1] > left[0][1]:
                        larger[left[0][0]] += len(right)
                        enum[i] = left.pop(0)
                    else:
                        enum[i] = right.pop(0)
            # print(enum, larger)
            return enum
        larger = [0] * len(nums)
        sortlarge(list(enumerate(nums)))
        return larger

pgm = Solution()
nums = range(10)
print("smaller", pgm.countSmaller(nums))
print("larger", pgm.countLarger(nums))
