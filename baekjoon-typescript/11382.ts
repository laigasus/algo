import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path);

const nums: Array<number> = input.toString().trim().split(" ").map(str => Number(str));

function addAll(nums: Array<number>): number {
    let sum = 0;

    for (const num of nums) {
        sum += num;
    }

    return sum;
}

console.log(addAll(nums));