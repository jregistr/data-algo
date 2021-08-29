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
