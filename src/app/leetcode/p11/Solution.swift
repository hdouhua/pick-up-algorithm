
class Solution {
    func maxArea(_ height: [Int]) -> Int {
        var area = 0
        var i = 0
        var j = height.count - 1
        while i < j {
            area = max(area, (j - i) * min(height[i], height[j]))
            if height[i] < height[j] {
                i += 1
            } else {
                j -= 1
            }
        }
        return area
    }

    func maxArea1(_ height: [Int]) -> Int {
        var area = 0
        var left = 0
        var right = height.count - 1
        var h = 0
        while left < right {
            if height[left] < height[right] {
                h = height[left]
                left += 1
            } else {
                h = height[right]
                right -= 1
            }
            area = max(area, (right - left + 1) * h)
        }
        return area
    }
}
