let resp
let continuar

let area
let linguagem
let linguagens

let especializacao

do {
    area = prompt('Qual aréa deseja seguir ?')

    if (area.toUpperCase() == 'BACKEND') {
        linguagem = prompt('Quer aprender React ou Vue ?')
    } else if (area.toUpperCase() == 'FRONTEND') {
        linguagem = prompt('Quer aprender C# ou Java ?')
    }

    especializacao = prompt(
        `Quer se especializar no ${area} ou se tornar um dev FullStack ?`
    )

    do {
        continuar = prompt(
            'Tem mais alguma tecnologia que você gostaria de aprender ?'
        )
        if (continuar.toLowerCase() == 's') {
            linguagens = prompt('Qual seria essa linguagem ?')
        }
    } while (continuar.toLowerCase() == 's')

    resp = prompt('Deseja continuar ?')
} while (resp == 's')
