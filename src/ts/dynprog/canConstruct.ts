/*
Write a function `canConstruct(target: string, wordBank: string[])` and return a boolean indicating
one can construct the target word by concatenating elements of the `wordBank` array.
- We may re-use elements of the wordBank as many times as needed

Examples:
canConstruct ("abcdef", ["ab", "abc", "cd", "def", "abcd"]) -> true
    abc + def

canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]) -> false
*/

function canConstruct(target: string, wordBank: string[]): boolean {
  if (target === "") return true;

  for (const bankWord of wordBank) {
    if (target.startsWith(bankWord)) {
      const remain = target.substring(bankWord.length);
      const canForRemain = canConstruct(remain, wordBank);
      if (canForRemain) return true;
    }
  }
  return false;
}

test("that we get true for the given inputs", () => {
  expect(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])).toBeTruthy();
  expect(canConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])).toBeTruthy();
});

test("that we get false for the given inputs", () => {
  expect(canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])).toBeFalsy();
});

/*
O(n * m^2)
    
*/
function canConstructMemo(target: string, wordBank: string[]): boolean {
  const memo = new Map<string, boolean>();

  function inner(target: string): boolean {
    if (memo.has(target)) return memo.get(target)!;
    if (target === "") return true;

    for (const bankWord of wordBank) {
      if (target.startsWith(bankWord)) {
        const remain = target.substring(bankWord.length);
        const canForRemain = inner(remain);
        memo.set(target, canForRemain);
        if (canForRemain) return true;
      }
    }
    return false;
  }

  return inner(target);
}

test("that we get true for the given inputs", () => {
  expect(canConstructMemo("abcdef", ["ab", "abc", "cd", "def", "abcd"])).toBeTruthy();
  expect(
    canConstructMemo("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])
  ).toBeTruthy();
});

test("that we get false for the given inputs", () => {
  expect(canConstructMemo("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])).toBeFalsy();
  expect(
    canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
      "e",
      "ee",
      "eeee",
      "eeeeeeee"
    ])
  ).toBeFalsy();
});

/*
Can construct using tabulation method 
*/

function canConstructTable(target: string, wordBank: string[]): boolean {
  const table = Array(target.length + 1).fill(false);
  table[0] = true;
  for (let i = 0; i <= target.length; i++) {
    if (table[i] == true) {
      for (const word of wordBank) {
        if (target.substring(i, i + word.length) == word) {
          table[i + word.length] = true;
        }
      }
    }
  }

  return table[target.length];
}

test("that we get true for the given inputs", () => {
  expect(canConstructTable("abcdef", ["ab", "abc", "cd", "def", "abcd"])).toBeTruthy();
  expect(
    canConstructTable("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])
  ).toBeTruthy();
});

test("that we get false for the given inputs", () => {
  expect(
    canConstructTable("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])
  ).toBeFalsy();
  expect(
    canConstructTable("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
      "e",
      "ee",
      "eeee",
      "eeeeeeee"
    ])
  ).toBeFalsy();
});
