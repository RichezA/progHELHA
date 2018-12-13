%include "io.inc"

section .text
global CMAIN
CMAIN:
extern _ReadConsoleA@20 ; lit la console
extern _GetStdHandle@4  ; fonction pour qu'on soit dans un standard
    ;write your code here
    push dword -11
    call _GetStdHandle@4
    mov [handle], eax
    
        
    xor eax, eax
    ret

section .data
    msg: db 'Hello World!', 0
    msg_L: equ $-msg