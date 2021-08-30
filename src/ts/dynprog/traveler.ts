/*
How many ways can you traverse a m by n grid when the only legal moves are
a down move and a right move.


| | | |
| | | |
*/

function gridTraveler(m: number, n: number): number {
  const memo = new Map<string, number>();

  function inner(m: number, n: number): number {
    const key = `${m}:${n}`;
    if (memo.has(key)) return memo.get(key)!;
    if (m === 1 && n === 1) return 1;
    if (m === 0 || n === 0) return 0;

    const ways = inner(m - 1, n) + inner(m, n - 1);
    memo.set(key, ways);
    return ways;
  }

  return inner(m, n);
}

test("large grid", () => {
  expect(gridTraveler(18, 18)).toBe(2333606220);
});

/*
Build a table.

gridTraveler(3,3) -> 6

Make 2d array 4x4
  __ __ __ __
0|
1|
2|
3|
*/

function gridTravelerTable(m: number, n: number): number {
  const table = Array(m + 1)
    .fill(0)
    .map(() => Array(n + 1).fill(0));
  table[1][1] = 1;

  for (let i = 0; i <= m; i++) {
    for (let j = 0; j <= n; j++) {
      const cur = table[i][j];
      if (j + 1 <= n) table[i][j + 1] += cur;
      if (i + 1 <= m) table[i + 1][j] += cur;
    }
  }

  return table[m][n];
}

test("that table grid traveler returns expected values", () => {
  expect(gridTravelerTable(1, 1)).toBe(1);
  expect(gridTravelerTable(2, 3)).toBe(3);
  expect(gridTravelerTable(3, 2)).toBe(3);
  expect(gridTravelerTable(3, 3)).toBe(6);
  expect(gridTravelerTable(18, 18)).toBe(2333606220);
});
