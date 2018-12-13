%include "io.inc"

section .text
global CMAIN
CMAIN:
extern _SetConsoleTitleA@4
    ;write your code here
    push titre
    call _SetConsoleTitleA@4
    Get:
        GET_CHAR edx
        cmp edx, 'q'
        JNE Get
    xor eax, eax
    ret
    
section .data
titre: db 'Asm Master', 0
titre_L: equ $-titre