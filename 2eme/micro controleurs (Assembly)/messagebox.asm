%include "io.inc"

section .data
msg: db "Gilet", 0
msg_L: equ $-msg ; current - msg

section .bss

section .text
    global CMAIN
    extern _MessageBoxA@16
    extern _ToAscii@16
CMAIN:
    push 40h ;information icon
    push 0
    push msg
    push 0
    call _MessageBoxA@16
    
    ;end program
    xor eax, eax
    ret
    