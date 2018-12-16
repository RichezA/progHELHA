%include "io.inc"

section .text
global CMAIN
CMAIN:
        extern  _ExitProcess@4
        extern  _WriteConsoleA@20   ; identique � console.writeline ou printf si vous voulez 
        extern  _ReadConsoleA@20    ; lit la console
        extern _GetStdHandle@4  ; fonction pour qu'on soit dans un standard
    ;write your code here
    
    ; output
    push dword -11
    call _GetStdHandle@4
    mov [handle], eax
    
    ; input
    push dword -10
    call _GetStdHandle@4
    mov [read_handle], eax
    
    ; WriteConsole
    push dword 0
    push written
    push dword 2
    push msg        
    push dword [handle]
    call _WriteConsoleA@20
    
    push eax
    mov eax, esp        ;buffer for read
    
    ;readConsole
    push 0
    push written
    push dword 1
    push eax
    push dword [read_handle]
    call _ReadConsoleA@20
    
    pop eax
    PRINT_CHAR 62
    JMP SEC1
    
    ; v is the only way to print the whole string, but it will the buffer at the same time
SEC1:
    PRINT_CHAR eax
    JMP CMAIN
    
    ;Exit process
    push 0
    call _ExitProcess@4
         
           
    ;xor eax, eax
    ;ret

section .data
    handle: dd 0
    read_handle: dd 0
    written: db 0
    msg: db 126
    