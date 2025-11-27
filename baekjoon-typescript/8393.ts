import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path).toString().trim().split("\n");

const n: number = Number(input[0]);

const nums: number[] = Array.from({ length: n }, (value, i) => i + 1);

let sum: number = 0;

for (const num of nums) {
    sum += num;
}

console.log(sum);