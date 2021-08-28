import { fibMemoized } from "./fib";

test("that 1 is 1", () => {
    expect(1).toBe(1);
})

test("that it returns fib of 4", () => {
    expect(fibMemoized(4)).toBe(3);
})

test("that it can return the fib of 45", () => {
    expect(fibMemoized(45)).toBe(1134903170)
})