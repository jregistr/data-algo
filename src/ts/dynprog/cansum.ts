/*
Write a function `canSum(target, numbers: [numbers])` tha returns a boolean indicating the
numbers in array can sum up to target.

- Use an element of the array as many times as needed
- All numbers in `numbers` are positive integers.

canSum(7, [5, 3, 4, 7]) --> true
    3 + 4
    7

canSum(7, [2, 4]) --> false
-------------------------------------------------------
Start with the solution. We can decrement our target sum by substracting
any of the values in the array and those each form some branch. 
canSum(7, [5, 3, 4, 7])
                |7|
        |-2| |-3|  |-4| |-7|
        (2)  (4)   (3)  (0)
    
Exclude out all numbers where we have no options for them in array and are not zero
*/

// Complexity: O(n^m) where m = target, n = array length
export function canSumBrute(target: number, numbers: number[]): boolean {
  if (target === 0) return true;
  if (target < 0) return false;

  for (const num of numbers) {
    const remain = target - num;
    if (canSumBrute(remain, numbers)) return true;
  }
  return false;
}

/*
Improved complexity with memoization: O(m * n)
worst case senario, we have a sum that we decrement by 1 all the way to the answer.
So we'll have m height. We branch out n times per node.
Thus, m * n
*/
export function canSum(target: number, numbers: number[]): boolean {
  const memo = new Map<number, boolean>();

  function inner(target: number): boolean {
    if (memo.has(target)) return memo.get(target)!;
    if (target === 0) return true;
    if (target < 0) return false;

    for (const num of numbers) {
      const remain = target - num;
      const canSumToRemain = inner(remain);
      if (canSumToRemain) return true;

      memo.set(target, canSumToRemain);
    }
    return false;
  }

  return inner(target);
}

describe("first solution", () => {
  it("should return true for these inputs", () => {
    expect(canSumBrute(7, [2, 3])).toBe(true);
    expect(canSumBrute(7, [5, 3, 4, 7])).toBe(true);
    expect(canSumBrute(8, [2, 3, 5])).toBe(true);
  });

  it("should return false for these inputs", () => {
    expect(canSumBrute(7, [2, 4])).toBeFalsy();
    // expect(canSumBrute(300, [7, 14])).toBeFalsy; // Takes a while to return
  });
});

describe("memoized solution", () => {
  test("that it returns false but without taking forever", () => {
    expect(canSum(300, [7, 14])).toBeFalsy();
  });
});
