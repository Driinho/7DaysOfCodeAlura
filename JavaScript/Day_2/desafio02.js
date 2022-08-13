// Por isso, hoje, eu vou te ensinar a desenvolver um programa simulando um desses sites. Ele deve pedir para o usuário responder 3 perguntas:

// - Qual o seu nome?
// - Quantos anos você tem?
// - Qual linguagem de programação você está estudando?

// À medida que as perguntas forem sendo feitas, a pessoa que estiver usando o programa deve responder cada uma delas.

// No final, o sistema vai exibir a mensagem:

// "Olá [nome], você tem [idade] anos e já está aprendendo [linguagem]!"

// Note que cada informação entre [ ] é uma das respostas dadas pela pessoa.

let nome
let idade
let linguagemDeProgramacao

const { devNull } = require('os')
const readline = require('readline')
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
rl.question('Qual o seu nome?', function (nome) {
    rl.question('Qual a sua idade?', function (idade) {
        rl.question(
            'Qual linguagem de programação você está estudando?',
            function (linguagemDeProgramacao) {
                console.log(
                    `Olá ${nome}, você tem ${idade} anos e já está aprendendo ${linguagemDeProgramacao}`
                )
            }
        )
    })
})
