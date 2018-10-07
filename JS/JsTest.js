const anglaisECTS = 15,progrECTS = 25, initPcECTS = 20; 

// tu demandes tes infos
let matriculeEtudiant = prompt("Quel est votre matricule ?");   //=> Accessible partout car ils sont pas "encapsulé" (enfermé entre deux {})
let coteAnglais = +prompt("cote en anglais");
let coteProg = +prompt("cote en prog");
let coteInit = +prompt("cote en init");

obtenirResultat(coteAnglais,coteProg,coteInit);

/*function calculMoyenne(coteAnglais, coteProg, coteInit)
{
    let moyenne = calculerMoyennePonderee(coteAnglais,coteProg,coteInit);

    if (moyenne >= 10 && moyenne < 12 && coteAnglais >=10 && coteProg >=10 && coteInit >= 10) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne);
    else if (moyenne >= 12 && moyenne < 14) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne + " crédits avec satisfaction");
    else if (moyenne >= 14 && moyenne < 16) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne + " crédits avec distinction");
    else if (moyenne >= 16 && moyenne < 20) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne + " crédits avec une grande distinction");
    else if (moyenne > 20) console.log(matriculeEtudiant + " Votre moyenne ne peut être supérieur à 20");
    else console.log(matriculeEtudiant + " Vous avez échoué");
}*/

function calculerMoyennePonderee( coteAnglais, coteProg, coteInit)
{
    let moyenne = (((coteAnglais/20)* anglaisECTS) + ((coteProg/20)* progrECTS) + ((coteInit/20)* initPcECTS))/3; // tu as déclaré la variable entre deux {} donc la variable n'existe qu'entre
    // les deux {}
    return moyenne;
}

function obtenirResultat(matriculeEtudiant, coteAnglais, coteProg, coteInit)
{
    let moyenne = calculerMoyennePonderee(coteAnglais, coteProg, coteInit);

    if (moyenne >= 10 && moyenne < 12 && coteAnglais >=10 && coteProg >=10 && coteInit >= 10) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne);
    else if (moyenne >= 12 && moyenne < 14) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne + " crédits avec satisfaction");
    else if (moyenne >= 14 && moyenne < 16) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne + " crédits avec distinction");
    else if (moyenne >= 16 && moyenne < 20) console.log(matriculeEtudiant + " Vous avez réussi avec une moyenne de : " + moyenne + " crédits avec une grande distinction");
    else if (moyenne > 20) console.log(matriculeEtudiant + " Votre moyenne ne peut être supérieur à 20");
    else console.log(matriculeEtudiant + " Vous avez échoué");
}