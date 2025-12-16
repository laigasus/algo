import {readFileSync} from "fs";

const fileName = __filename.split('\\').pop().split('.')[0];
const path = process.platform === "linux" ? "/dev/stdin" : `./input/${fileName}.txt`;
const args = readFileSync(path).toString().trim().split("\n");

function main(args){
    const T:number = Number(args[0])

    const arr: Array<string> = new Array<string>()

    for(let i =1; i<= T; i++){
        const arg = args[i]
        const start = arg[0]
        const end = arg[arg.length-1]

        arr.push(`${start}${end}`)
    }

    console.log(arr.join('\n'))

}

main(args)