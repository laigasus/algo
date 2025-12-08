import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path).toString().trim().split("\n");

function main() {
    const X: number = Number(input[0]);
    const N: number = Number(input[1]);

    let sum: number = 0;
    for (var i = 2; i < N + 2; i++) {
        const tmp: string[] = input[i].split(" ");
        const price: number = Number(tmp[0]);
        const quantity: number = Number(tmp[1]);

        sum += price * quantity;
    }

    console.log(X == sum ? "Yes" : "No");
}

main();
