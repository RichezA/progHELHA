%include "io.inc"

section .text
global CMAIN
CMAIN:
    extern _SetConsoleCursorPosition@8
    extern _GetStdHandle@4
    ;import SetConsoleCursorPosition kernel32.dll
    ;import GetStdHandle kernel32.dll
    
    ; handle = GetStdHandle(-11)
    push dword -11
    call _GetStdHandle@4
    mov [handle], eax
    
    ;PRINT_STRING "Début"
    
    ; coords + call of SetConsole
    mov ax, 15 ; low order bits to new x coordinate
    shl eax, 16  ; shift the bits left, high order part is 15
    mov ax, 0   ; should be 0 but it's to be sure
    push eax    ; push coords to the stack
    push dword [handle] ; push the handle to the stack
    call _SetConsoleCursorPosition@8
    ;PRINT_STRING "LOL ça marche"
    
    xor eax, eax
    ret

section .data
    handle: dd 0