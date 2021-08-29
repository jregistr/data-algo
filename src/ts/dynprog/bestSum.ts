/*
Write a function bestSum(target, numbers) that returns an array containing
the shortest combination of numbers that add up to the targetSum.

- Use an element of the array as many times as needed
- All numbers in `numbers` are positive integers.

Examples:
canSum(7, [5, 3, 4, 7])
    Valid arrays are [3, 4] and [7], the smaller of the two should be returned [7]
*/

/*
let m = target
let n = len(numbers)
*/

/*
Time: O(m * n^m)
Space: O(m^2)
*/
function bestSum(target: number, numbers: number[]): number[] | null {
  if (target === 0) return [];
  if (target < 0) return null;

  let smallestArr: number[] | null = null;
  for (const current of numbers) {
    const remain = target - current;
    const resArr = bestSum(remain, numbers);
    if (resArr !== null) {
      if (smallestArr == null || resArr.length + 1 < smallestArr.length) {
        smallestArr = [...resArr, current];
      }
    }
  }
  return smallestArr;
}

test("that it returns an array with only 7", () => {
  expect(bestSum(7, [5, 3, 4, 7])).toEqual([7]);
  expect(bestSum(8, [2, 3, 5])).toEqual([5, 3]);
});

// takes too long :)
// test("that it returns 50 and 250", () => {
//     expect(bestSum(300, [60, 2, 50, 7, 250])).toEqual([50, 250])
// })

/*
Time: O(n*m^2)
Space: O(m^2)
*/
function bestSumMemoized(target: number, numbers: number[]): number[] | null {
  const memo = new Map<number, number[] | null>();

  function inner(target: number): number[] | null {
    if (memo.has(target)) return memo.get(target)!;
    if (target === 0) return [];
    if (target < 0) return null;

    let smallestArr: number[] | null = null;
    for (const current of numbers) {
      const remain = target - current;
      const resArr = inner(remain);
      if (resArr) {
        if (smallestArr == null || resArr.length + 1 < smallestArr.length) {
          smallestArr = [...resArr, current];
        }
      }
    }
    memo.set(target, smallestArr);
    return smallestArr;
  }

  return inner(target);
}

test("that it returns 50 and 250 as the smallest combination", () => {
  expect(bestSumMemoized(7, [5, 3, 4, 7])).toEqual([7]);
  expect(bestSumMemoized(8, [2, 3, 5])).toEqual([5, 3]);
  expect(bestSumMemoized(100, [1, 2, 5, 25])).toEqual([25, 25, 25, 25]);
  expect(bestSumMemoized(300, [2, 50, 7, 250])).toEqual([250, 50]);
});
