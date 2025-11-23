import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const input = readFileSync(path);

const str: String = input.toString();
const arr: Array<number> = str.split(" ").map(Number);

const [a, b] = arr;

class Calc {
    private a: number;
    private b: number;

    constructor(a: number, b: number) {
        this.a = a;
        this.b = b;
    }

    add(): number {
        return a + b;
    }

    subtract(): number {
        return a - b;
    }

    divide(): number {
        return Math.trunc(a / b);
    }

    multiply(): number {
        return a * b;
    }

    remains(): number {
        return a % b;
    }
}

const calc1 = new Calc(a, b);

console.log(calc1.add());
console.log(calc1.subtract());
console.log(calc1.multiply());
console.log(calc1.divide());
console.log(calc1.remains());