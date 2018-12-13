#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>

int main(void)
{
    COORD newPosition = {10, 20};

    system("pause");
    printf("Hello World\n");

    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), newPosition);
    printf("New position");
    printf("\n");
    return 0;
}
// charger une chaine de caractères (demandée à l'utilisateur) : rouge, bleu, jaune, vert
// demander  à l'utilisateur de rentrer un index : 2
// affiche le mot : jaune