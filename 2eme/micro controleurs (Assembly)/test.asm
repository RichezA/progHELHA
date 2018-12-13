%include "io.inc"
section .text
global CMAIN
extern _Sleep@4
extern printf
CMAIN:
    ;write your code here
    push dword 1000 ;obliged to push a dword value for the sleep (in ms)
    call _Sleep@4
    
    push m1
    call printf
    add esp, 4
    
    ;push dword 1000
    ;call _Sleep@4
    ;push m2
    ;call printf
    ;add esp, 4
    
    ;push dword 1000
    ;call _Sleep@4   
    ;push m3
    ;call printf
    ;add esp, 4
    
    ;push dword 1000
    ;call _Sleep@4
    ;push m4
    ;call printf
    ;add esp, 4
    
    ;push dword 1000
    ;call _Sleep@4
    ;push message
    ;call printf
    ;add esp, 4
    
    
    xor eax, eax
    ret
section .data
message: db 10,13, "Hello World",0
m1: db '1', 42      ; si pas de 0 pas de retour à la ligne ->on continue à lire les valeurs jusqu'à ce qu'on rencontre un 
                    ; un saut de ligne ou un enter etc
m2: db '2', 42, 0
m3: db '3', 42, 0
m4: db '4', 42, 0
;db directive byte -> 1 byte
;dw directive word -> 2 bytes
;dd directive double word -> 4 bytes
;dq directive quadra word -> 8 bytes