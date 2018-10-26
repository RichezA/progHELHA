//introduction array
let pizzas = []
//fonction 1 = introduction nombre de pizzas

function introduirePizzas() {
    let nbPizza = ""
    while (nbPizza != "fin") {
        //introduction nombre Pizza par l'utilisateur
        nbPizza = prompt("Introduire nombre de pizza par semaine (fin pour stopper - sup pour supprimer la dernière saisie et reinit pour mettre à 0)");
        //vérification introduction n'est pas autre mot clé et un nombre plus grand que zéro entier
        if ((nbPizza != "sup") && (nbPizza != "reinit") && (nbPizza >= 0) && ((nbPizza % 2 == 0) ||
                (nbPizza % 2 == 1))) {
            nbPizza = Number(nbPizza);
            //incrémentation array
            pizzas.push(nbPizza);
        }
        if (nbPizza < 0) {
            alert("Veuillez entrer un nombre entier positif");
        } else if (nbPizza == "sup") {
            pizzas.pop();
        } else if (nbPizza == "reinit") {
            pizzas = []
        }
    }
    console.log(pizzas)
    return pizzas;
}

function afficherNombreSemaine(pizzas) {
    let nombreSemaine = pizzas.length;
    if (nombreSemaine == 0) {
        alert("Veuillez cliquer sur le bouton 1");
    } else console.log("Vous avez introduit des données pour " + nombreSemaine + " semaine(s)");
    return nombreSemaine;
}

function afficherPizzasParSemaine(pizzas) {
    for (let i = 0; i < pizzas.length; i++) {
        if (pizzas[i] > 1) {
            pizza = "pizzas";
        } else pizza = "pizza";
        console.log("Lors de la semaine " + (i + 1) + "," + " vous avez mangé " + pizzas[i] + " " + pizza);
    }
}

function afficherMaximumPizza(pizzas) {
    let maximumPizza = 0
    for (let i = 0; i < pizzas.length; i++) {
        if (pizzas[i] > maximumPizza) {
            maximumPizza = pizzas[i];
        }
    }
    console.log("Le plus grand nombre de pizzas mangées en une semaine est de " + maximumPizza + ".");
}

function afficherPlusDe3Pizzas(pizzas) {
    const limite = 3
    let plusDe3 = 0
    if (pizzas.length == 0) {
        alert("Veuillez cliquer sur le bouton 1");
    } else
        for (let i = 0; i < pizzas.length; i++) {
            if (pizzas[i] > limite) {
                plusDe3 += 1;
            }
        }
    console.log("Vous avez mangé " + plusDe3 + " fois plus de 3 pizzas par semaines.");
}

function afficher4DernieresSemaine(pizzas) {
    let semaineDemandee = +prompt("Calculer la somme de pizza consommée ces ... dernières semaines");
    let sommePizza4DerSem = 0;
    let semTotal = pizzas.length;
    for (let i = semTotal - semaineDemandee; i < semTotal; i++) {
        sommePizza4DerSem += pizzas[i];
    }
    console.log("Depuis ces " + semaineDemandee + "dernières semaines, vous avez consommé " + sommePizza4DerSem + " pizzas.");
}

function compterTotalPizzas(pizzas) {
    // but de la fonction = compter le total
    let sommePizza = 0
    for (let i = 0; i < pizzas.length; i++) {
        sommePizza += pizzas[i];
    }
    return (sommePizza);
}

function afficherPoidsPizzas(pizzas) {
    const POIDS_PIZZA = 0.25; // constante
    let sommePizza = compterTotalPizzas(pizzas);
    sommePizza *= POIDS_PIZZA;
    console.log("Vous avez mangé " + sommePizza);
}