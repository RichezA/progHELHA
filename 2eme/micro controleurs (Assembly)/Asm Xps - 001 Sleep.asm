%include "io.inc"
section .text
global CMAIN
extern _Sleep@4
extern printf
CMAIN:
    mov ebp, esp; for correct debugging
    push dword 1000 
    call _Sleep@4

    push m1
    call printf
    add esp, 4
    
    push dword 1000 
    call _Sleep@4
    push m2
    call printf
    add esp, 4
    
    push dword 1000 
    call _Sleep@4
    push m3
    call printf
    add esp, 4
    
    push dword 1000 
    call _Sleep@4
    push m4
    call printf
    add esp, 4
    
    push message
    call printf
    add esp, 4
    xor eax, eax
    ret
section .data
message:db  10,'Hello, World',0
m1:     db  '1',42,0
m2:     db  '2',42,0
m3:     db  '3',42,0
m4:     db  '4',42,0