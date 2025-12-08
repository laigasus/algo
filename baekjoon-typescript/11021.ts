import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path).toString().trim().split('\n');


function main() {
    const T: number = Number(input[0]);

    const stringBuilder: Array<string> = new Array<string>();

    for (let i = 1; i <= T; i++) {
        const [a, b] = input[i].split(" ").map(Number);

        stringBuilder.push(`Case #${i}: ${sum(a, b)}`);
    }

    console.log(stringBuilder.join("\n"));
}

function sum(A: number, B: number): number {
    return A + B;
}

main();

