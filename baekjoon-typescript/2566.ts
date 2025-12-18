import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split("\n");

function main(args: string[]) {
    const nums: number[][] = args.map(line => line.split(" ").map(Number));

    let max: number = -1, maxIdxY = -1, maxIdxX = -1;
    for (let y: number = 0; y < nums.length; y++) {
        for (let x: number = 0; x < nums.length; x++) {
            if (nums[y][x] >= max) {
                max = nums[y][x];
                maxIdxY = y + 1;
                maxIdxX = x + 1;
            }
        }
    }

    console.log(max);
    console.log(maxIdxY, maxIdxX);
}

main(args);