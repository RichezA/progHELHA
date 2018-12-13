%include "io.inc"

section .data
msg: db "Gilet", 0
msg_L: equ $-msg ; current - msg
msg2: db "T'ES GAY",0 ; valeur ascii 0 -> saut de ligne | ici pas obligé car c'est la dernière valeur
msg2_L: equ $-msg2

section .bss

section .text
    global CMAIN
    extern _MessageBoxA@16
    extern _ToAscii@16
CMAIN:
    mov ebp, esp; for correct debugging
    push 43h ;information icon 
    push msg2
    push msg
    push 0
    call _MessageBoxA@16
    cmp eax, 0x06
    JNE CMAIN
    cmp eax, 0x07
    JNE CMAIN
    ;end program
    xor eax, eax
    ret
    