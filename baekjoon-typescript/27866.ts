import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split('\n');


function main(args) {
    const S: string = args[0]

    const i: number = args[1]

    console.log(S[i - 1]);
}

main(args)