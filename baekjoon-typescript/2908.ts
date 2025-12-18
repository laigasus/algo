import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split('\n') || [];

function main(args) {
    const arr: string[] = String(args[0]).split(" ");

    const rs: number = Math.max(
        reverseAndConvertNumber(String(arr[0]).split("")),
        reverseAndConvertNumber(String(arr[1]).split("")),
    )

    console.log(rs);
}

main(args);

function reverseAndConvertNumber(arr: string[]): number {
    let str = ""

    for (let i = arr.length - 1; i >= 0; i--) {
        str += arr[i]
    }

    return Number(str)
}
