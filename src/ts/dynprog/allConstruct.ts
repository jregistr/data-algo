/*
Followup to canConstruct, let's write allConstruct(target: string, wordBank: string[]): string[][]
that returns all the combinations of elements in the word bank that can be concatenated to create the
target word.

Examples:
allConstruct ("purple", ["purp", "p", "ur", "le", "purpl"]) -> 
[
    [purp, le],
    [p, ur, p, le]
]

allConstruct("abcdef", [ab, abc, cd, def, abcd, ef, c])
[
    [ab, cd, ef],
    [ab, c, def],
    [abc, def],
    [abcd, ef]
]
*/

/*
time: O(m * n^m)
Space: O(m)
*/
function allConstruct(target: string, wordBank: string[]): string[][] {
    if (target === "") return [[]];

    const combinations: string[][] = [];
    for (const word of wordBank) {
        if (target.startsWith(word)) {
            const remain = target.substring(word.length);
            const suffixWays = allConstruct(remain, wordBank)
                .map((value) => [word, ...value]);
            combinations.push(...suffixWays);
        }
    }

    return combinations;
}

test("that it returns an expected 2D array for abcdef", () => {
    const expected = [
        ["ab", "cd", "ef"],
        ["ab", "c", "def"],
        ["abc", "def"],
        ["abcd", "ef"]
    ];
    expect(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd", "ef", "c"])).toEqual(expected)
});

test("that it returns expected values", () => {
    expect(allConstruct("purple", ["purp", "p", "ur", "le", "purpl"])).toEqual([
        ["purp", "le"],
        ["p", "ur", "p", "le"]
    ])
});


function allConstructMemo(target: string, wordBank: string[]): string[][] {
    const memo = new Map<string, string[][]>();
    function inner(target: string): string[][] {
        if (memo.has(target)) memo.get(target)!;
        if (target === "") return [[]];

        const combinations: string[][] = [];
        for (const word of wordBank) {
            if (target.startsWith(word)) {
                const remain = target.substring(word.length);
                const suffixWays = inner(remain)
                    .map((value) => [word, ...value]);
                combinations.push(...suffixWays);
            }
        }

        memo.set(target, combinations);
        return combinations;
    }

    return inner(target);
}


test("that it returns an expected 2D array for abcdef", () => {
    const expected = [
        ["ab", "cd", "ef"],
        ["ab", "c", "def"],
        ["abc", "def"],
        ["abcd", "ef"]
    ];
    expect(allConstructMemo("abcdef", ["ab", "abc", "cd", "def", "abcd", "ef", "c"])).toEqual(expected);
});

test("that it returns expected values", () => {
    expect(allConstructMemo("purple", ["purp", "p", "ur", "le", "purpl"])).toEqual([
        ["purp", "le"],
        ["p", "ur", "p", "le"]
    ]);

    expect(allConstructMemo("aaaaaaaaaaaaaaaaaaaaaaaaaaz", ["a", "aa", "aaa", "aaaa", "aaaaa"])).toEqual([]);
});