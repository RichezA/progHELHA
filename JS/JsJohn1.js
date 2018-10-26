function compterTotalPizzas(pizzas) {
	let sommePizza = 0; //existe
	for (let i = 0; i < pizzas.length; i++) {
		sommePizza += pizzas[i]; // existe
	}
	return sommePizza; // existe
}
console.log(sommePizza); // EXISTE PAS

function afficherPoidsPizzas(pizzas) {
	const POIDS_PIZZA = 0.25; // constante
	let sommePizza = compterTotalPizzas(pizzas); // existe
	sommePizza *= POIDS_PIZZA; // égal à sommePizza = sommePizza * POIDS_PIZZA
	console.log(sommePizza);
}

let poids = afficherPoidsPizzas(pizzas);
console.log(poids); // là tu as la variable
