import { readFileSync } from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path).toString().trim();

function withInterjection(word: string): string {
    return word + '??!';
}

console.log(withInterjection(input));