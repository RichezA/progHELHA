#include <iostream>

int main()
{
    int t[10];
    std::cout << t; // affiche l'adresse contenue dans la pointeur
    // t = 0x8ffee
    t + 1; // équivalent à &t[1]
    // 0x8fff3
    *(t + 1); // équivalent à t[1]

    int t2[3][4];
    t2;     // équivalent à &t2[0][0] ou t2[0]
    t2 + 2; // équivalent à &t2[2][0] ou t2[2]
}