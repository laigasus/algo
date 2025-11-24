import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path);

const [A, B]: number[] = input.toString().split(" ").map(Number);

function numberCompare(a: number, b: number): string {
    const BIGGER: number = 1;
    const SMALLER: number = -1;
    const SAME: number = 0;

    const pattern: object = {
        [BIGGER]: '>',
        [SMALLER]: '<',
        [SAME]: '==',
    }

    return pattern[Math.sign(a - b)];
}

console.log(numberCompare(A, B));