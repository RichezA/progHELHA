#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
#include <iostream>
int main(void)
{
    COORD newPosition = {10, 20};
    int i = 0;
    int *j = &i;
    // system("pause");
    // printf("Hello World\n");
    std::cout << j << std::endl;
    // SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), newPosition);
    // printf("New position");
    // printf("\n");
    return 0;
}
// charger une chaine de caractères (demandée à l'utilisateur) : rouge, bleu, jaune, vert
// demander  à l'utilisateur de rentrer un index : 2
// affiche le mot : jaune