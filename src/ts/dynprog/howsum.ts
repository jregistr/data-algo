/*
write a function howSum(target, numbers) that takes in a target and an array of numbers

return an arary containing any combination of numbers that add up to the target sum
- If there are multiple possible sums, return any 1
- re-use any number in the array as needed

Examples:
7, [5, 3, 4, 7] -> [3, 4] or [7]
8, [2, 3, 5] --> [2, 2, 2] or [3, 5]
7, [2, 4] --> null
*/

function howSum(target: number, numbers: number[]): number[] | null {
  // base case, target is 0. An empty array's values sum up to 0
  if (target === 0) return [];
  if (target < 0) return null;

  for (const current of numbers) {
    const remain = target - current;
    const sumArr = howSum(remain, numbers);
    if (sumArr) {
      // js truthy :)
      sumArr.push(current);
      return sumArr;
    }
  }
  return null;
}

it("should return [3,4]", () => {
  expect(howSum(7, [5, 3, 4, 7])).toEqual([4, 3]);
});

it("should return 2s", () => {
  expect(howSum(8, [2, 3, 5])).toEqual([2, 2, 2, 2]);
});

/*
time: O(n * m)
Space: O(m^2)
*/
function howSumMemoized(target: number, numbers: number[]): number[] | null {
  const memo = new Map<number, number[] | null>();

  function inner(target: number): number[] | null {
    if (memo.has(target)) return memo.get(target)!;
    if (target === 0) return [];
    if (target < 0) return null;

    for (const current of numbers) {
      const remain = target - current;
      const sumArr = howSumMemoized(remain, numbers);
      if (sumArr) {
        sumArr.push(current);
        memo.set(target, sumArr);
        return sumArr;
      }
    }

    memo.set(target, null);
    return null;
  }
  return inner(target);
}

test("that it returns expected values for small and even large inputs", () => {
  expect(howSumMemoized(7, [5, 3, 4, 7])).toEqual([4, 3]);
  expect(howSumMemoized(300, [60, 2, 50, 7, 250])).toEqual([60, 60, 60, 60, 60]);
});
