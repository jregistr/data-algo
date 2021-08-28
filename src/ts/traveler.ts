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
        if (memo.has(key)) return memo.get(key)!
        if (m === 1 && n === 1) return 1;
        if (m === 0 || n === 0) return 0;

        const ways = inner(m - 1, n) + inner(m, n - 1);
        memo.set(key, ways);
        return ways;
    }

    return inner(m, n);
}


console.log(gridTraveler(18, 18))