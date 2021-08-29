/*
Follow-up to canConstruct.ts.
Write a function countConstruct(target: string, wordBank: string[]): number
that returns the number of ways that the `target` can be constructed by concatenating elements of the
wordbank.

As before, we can re-use the elements of wordBank as many times as needed.

Examples:
countConstruct ("abcdef", ["ab", "abc", "cd", "def", "abcd"]) -> 1
    abc + def

countConstruct ("purple", ["purp", "p", "ur", "le", "purpl"]) -> 2
purp + le
p + ur + p + le
*/

function countConstruct(target: string, wordBank: string[]): number {
    if (target === "") return 1;

    let count = 0;
    for (const word of wordBank) {
        if (target.startsWith(word)) {
            const remain = target.substring(word.length);
            const ways = countConstruct(remain, wordBank);
            count += ways;
        }
    }
    return count;
}

test("that we get expected counts for the specified inputs", () => {
    expect(countConstruct("purple", ["purp", "p", "ur", "le", "purpl"])).toBe(2);
    expect(countConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])).toBe(4);
    expect(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])).toBe(1);
});

function countConstructMemo(target: string, wordBank: string[]): number {
    const memo = new Map<string, number>();

    function inner(target: string): number {
        if (memo.has(target)) return memo.get(target)!;
        if (target === "") return 1;

        let count = 0;
        for (const word of wordBank) {
            if (target.startsWith(word)) {
                const remain = target.substring(word.length);
                const ways = inner(remain);
                count += ways;
            }
        }

        memo.set(target, count);
        return count;
    }
    return inner(target);
}


test("that we get expected counts for the specified inputs", () => {
    expect(countConstructMemo("purple", ["purp", "p", "ur", "le", "purpl"])).toBe(2);
    expect(countConstructMemo("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])).toBe(4);
    expect(countConstructMemo("abcdef", ["ab", "abc", "cd", "def", "abcd"])).toBe(1);
    expect(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", ["e", "eeee", "ef", "eeee", "eeeeeeee"])).toBe(405448622);
});