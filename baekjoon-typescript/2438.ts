import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split('\n');

function main(args) {
    const N: number = Number(args[0]);

    const sb: string[] = [];

    for (let i = 1; i <= N; i++) {
        sb.push("*".repeat(i));
    }

    console.log(sb.join('\n'))
}

main(args);

