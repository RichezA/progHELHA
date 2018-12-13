%include "io.inc"
section .text
global CMAIN
extern _ReadConsoleA@20
extern _GetStdHandle@4

CMAIN:
    mov ebp, esp; for correct debugging
    push    dword -11   ; standard output device
    call    _GetStdHandle@4 ; call GetStdHandle function
    mov     [handle], eax   ; mov handle to eax
    
    push -10  ; stdin standard input device
    call _GetStdHandle@4    ; call GetStdHandle function
    mov [read_handle], eax  ; move read_handle to eax
    
    push eax                ; push eax to the stack
    mov eax, esp ; buffer for char
    push 0      ; push 0   to the stack
    push written    ; push written to the stack
    push dword 1    
    push eax    ; push eax to the stack
    push dword [read_handle]    ; push read_handle to the stack
    call _ReadConsoleA@20       ; call ReadConsole function
    pop eax                     ; pop eax from the stack
    
    JMP sect1
   
    xor eax, eax
    ret

sect1:
    PRINT_CHAR eax ; print eax to the screen
    JMP CMAIN       
 
section .data 
    msg: db "Hello World!",0
    msg_L: equ $-msg
    handle: dd 0
    read_handle: dd 0
    written: db 0

    