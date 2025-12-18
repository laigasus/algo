import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split('\n');

function main(args) {
    const N = Number(args[0]);


    let sum: number = 0;
    for (const num of String(args[1]).split("").map(Number)) {
        sum += num;
    }

    console.log(sum);
}

main(args);