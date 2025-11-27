import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path).toString().trim().split("\n");

const T: number = Number(input[0]);

for (let i: number = 1; i <= T; i++) {
    const [A, B]: number[] = input[i].split(" ").map(Number);

    console.log(A + B)
}