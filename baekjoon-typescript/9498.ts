import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path);

function estimateRank(score: number): string {
    const rank: { [key: number]: string } = {
        10: 'A',
        9: 'A',
        8: 'B',
        7: 'C',
        6: 'D',
        0: '0',
    };

    return rank[Math.trunc(score / 10)] || 'F';
}

const score: number = Number(input.toString().trim());
console.log(estimateRank(score));