import { readFileSync } from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path);

const str: String = input.toString();
const arr: Array<number> = str.split(" ").map(Number);

const [a, b] = arr;

function multiply(a: number, b: number): number {
    return a * b;
}

console.log(multiply(a, b));