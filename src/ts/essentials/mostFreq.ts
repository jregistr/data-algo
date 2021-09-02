
function mostFreq(nums: number[]): number {
    if (nums.length === 0) return 0;

    let mostFreqNum: number = nums[0];
    let mostFreqCount: number = 1;
    const found = new Map<number, number>([[mostFreqNum, mostFreqCount]]);
    for (const num of nums.slice(1)) {
        if (found.has(num)) {
            const numCount = found.get(num)! + 1;
            if (mostFreqCount < numCount) {
                mostFreqCount = numCount;
                mostFreqNum = num;
            }
            found.set(num, numCount);
        } else {
            found.set(num, 1);
        }
    }
    return mostFreqNum;
}

test("that it returns the most frequently occurring numbers", () => {
    expect(mostFreq([1, 3, 1, 3, 2, 1])).toBe(1);
    expect(mostFreq([])).toBe(0);
    expect(mostFreq([0, -1, 10, 10, -1, 10, -1, -1, -1, 1])).toBe(-1);
})