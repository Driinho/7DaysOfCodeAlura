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

var readline = require('readline')

var leitor = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

leitor.question('Qual o seu nome ?\n', function (answer) {
    nome = answer
    leitor.close()
})

leitor.question('Qual a sua idade ?\n', function (answer) {
    idade = answer
    leitor.close()
})

leitor.question(
    'Qual liguagem de programação você estuda ?\n',
    function (answer) {
        linguagemDeProgramacao = answer
        console.log(
            'Olá ' +
                nome +
                ' você tem ' +
                idade +
                ' anos e ja está aprendendo ' +
                linguagemDeProgramacao
        )
        leitor.close()
    }
)
