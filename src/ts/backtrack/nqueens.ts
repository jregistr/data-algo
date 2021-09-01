/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

Backtracking Solutions Template

Check that the current state is a valid solution
function isValidState(state: Set): boolean

Find a list of candidates that can be used to construct the next state
Ex: Current state has 1 queen in top left corner, come up with all the possible states from this point
function getCandidates(state: Set): Set

recursive fucntion.
function search(state: Set, solutions: [state])
    if state is valid:
        solutions.push(state.deepCopy())
        short circuit by returning

    for each candidate in getCandidates(state):
        state.add(candidate)
        search(state, solutions)
        state.remove(candidate)


function solve(): [][] {
    solutions = []
    state = new Set()
    search(state, solutions)
    return solutions
}
*/

/*
Refer to queens.jpg for examples of valid states
*/


/*
Let's represent the queen positions in an array of numbers where each number represents the queens column in its row
and each space in the array represents a row.

1st image example: [1, 3, 0,  2]
2nd image ex: [2, 0, 3, 1]
*/

// test("that it places the queens in the expected locations", () => {
//     expect(solveNQueens(4)).toEqual([[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]])
// })
/*
console.log(solveNQueens(4))

function solveNQueens(n: number): string[][] {
    const solutions: number[][] = [];
    const startState: number[] = [];
    searchSolutions(startState, solutions, n);
    return convertToOutputFormat(solutions, n);
}

function convertToOutputFormat(solutions: number[][], n: number): string[][] {
    const output: string[][] = [];
    for (const state of solutions) {
        const stateAsStrArr: string[] = [];
        for (let i = 0; i < state.length; i++) {
            const str = `${".".repeat(i)}Q${".".repeat(n - i - 1)}`;
            stateAsStrArr.push(str);
        }
        output.push(stateAsStrArr);
    }
    return output;
}

function searchSolutions(state: number[], solutions: number[][], n: number) {
    if (stateIsValid(state, n)) {
        solutions.push([...state])
        return;
    }

    for (const candidate of getCandidates(state, n)) {
        state.push(candidate);
        searchSolutions(state, solutions, n)
        state.pop();
    }
}

function stateIsValid(state: number[], n: number): boolean {
    return state.length == n;
}

function getCandidates(state: number[], n: number): number[] {
    if (state.length === 0) {
        return Array.from(Array(n).keys());
    }

    // find valid positions
    // if we have 1 queen placed down, the length of state will be 1
    let position = state.length;
    const candidates = new Set(Array.from(Array(n).keys()));
    // prune candidates that make a queen attackable
    for (let row = 0; row < state.length; row++) {
        const col = state[row];
        //discard if it's occupied
        candidates.delete(col);
        // discard diagonal positions
        const dist = position - row;
        candidates.delete(col + dist);
        candidates.delete(col - dist);
    }
    return Array.from(candidates.values());
}*/