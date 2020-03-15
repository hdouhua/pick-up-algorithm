
func moveZeroes(_ nums: inout [Int]) {
    let count = nums.count
    var nonZeroIndex = 0
    for i in 0 ..< count {
        if nums[i] != 0 {
            nums[nonZeroIndex] = nums[i]
            nonZeroIndex += 1
        }
    }

    // set zero
    for i in nonZeroIndex ..< count {
        nums[i] = 0
    }
}

func moveZeroes2(_ nums: inout [Int]) {
    let count = nums.count
    var nonZeroIndex = 0
    for i in 0 ..< count {
        if nums[i] != 0 {
            nums[nonZeroIndex] = nums[i]
            if i != nonZeroIndex {
                nums[i] = 0
            }
            nonZeroIndex += 1
        }
    }
}

func moveZeroes3(_ nums: inout [Int]) {
    let count = nums.count
    var nonZeroIndex = 0
    for i in 0 ..< count {
        if nums[i] != 0 {
            nums.swapAt(i, nonZeroIndex)
            nonZeroIndex += 1
        }
    }
}
