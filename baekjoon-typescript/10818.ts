import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split('\n')


function main(args: string[]) {
    const MIN_VALUE = -1000000;
    const MAX_VALUE = 1000000;

    const N = Number(args[0]);

    const nums: number[] = args[1].split(" ").map(Number);

    let min: number = MAX_VALUE;
    let max: number = MIN_VALUE;

    for (let num of nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    console.log(`${min} ${max}`);
}

main(args)