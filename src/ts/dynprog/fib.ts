export function fib_bad(n: number): number {
  if (n <= 2) return 1;

  return fib_bad(n - 1) + fib_bad(n - 2);
}

// console.log(fib_bad(6));

// console.log(fib_bad(45));

export function fibMemoized(n: number): number {
  const memo = new Map<number, number>();

  function inner(n: number): number {
    if (memo.has(n)) return memo.get(n)!;
    if (n <= 2) return 1;

    const fib = inner(n - 1) + inner(n - 2);
    memo.set(n, fib);
    return fib;
  }
  return inner(n);
}

console.log(fibMemoized(100));

test("that it returns fib of 4", () => {
  expect(fibMemoized(4)).toBe(3);
});

test("that it can return the fib of 45", () => {
  expect(fibMemoized(45)).toBe(1134903170);
});

// --------------------------------- Tabulation -------------------------------
/*
fib(6) -> 8
start with fib + 1 length array of zeroes. Second index is set to 1.
With a current pointer at 1, add 1 to the next 2 positions, avoiding out of bounds error.
[0, 1, 1, 2, 3, 5, 8]
O(n) time and space
*/


function fibTable(n: number): number {
  const table = Array<number>(n + 1).fill(0);
  table[1] = 1;
  for (let i = 0; i <= n; i++) {
    const [i1, i2] = [i + 1, i + 2];
    table[i1] += table[i];
    table[i2] += table[i];
  }

  return table[n];
}

test("expected tabulation results", () => {
  expect(fibTable(6)).toBe(8);
  expect(fibTable(7)).toBe(13);
  // expect(fibTable(50)).toBe()
})