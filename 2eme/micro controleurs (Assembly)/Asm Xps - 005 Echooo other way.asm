%include "io.inc"
section .text
; ----------------------------------------------------------------------------
; Cascio T.
; Asm XPs 004
; 
; ----------------------------------------------------------------------------


global CMAIN
global Start
        extern  _ExitProcess@4      ; identique � ;xor eax, eax ;ret sert � sortir du programme (uniquement sous Windows)
        extern  _GetStdHandle@4
        extern  _WriteConsoleA@20   ; identique � console.writeline ou printf si vous voulez 
        extern  _ReadConsoleA@20    ;
        extern  _SetConsoleTitleA@4
        
        CEXTERN scanf

        section .data

        msg:
        db 'Cascio, Soft Inc',10
        handle:
        dd 0
        read_handle:
        dd 0
        written:
        db 0


CMAIN:
    mov ebp, esp; for correct debugging

Start:
        ;push dword 0
        ;push Titre
        ;push dword 10
        call _SetConsoleTitleA@4
        
        ; handle = GetStdHandle(-11)
        push    dword -11           ;output
        call    _GetStdHandle@4
        mov     [handle], eax

        ; read_handle = GetStdHandle(-10)
        push -10  ; stdin
        call _GetStdHandle@4
        mov [read_handle], eax

        ; WriteConsole(handle, &msg[0], 13, &written, 0)
        push    dword 0 ; lpReserved
        push    written ; numbersOfCharWritten
        push    dword 13    ; numbersOfCharToWrite
        push    msg         ; buffer
        push    dword [handle]  ; console output
        call    _WriteConsoleA@20

        push eax
        mov eax, esp                ; buffer for char

        push 0                      ; InputControl
        push written                ; numberOfCharsRead
        push 1                      ; characters to read
        push eax                    ; buffer
        push dword [read_handle]    ; console input
        call  _ReadConsoleA@20
        PRINT_CHAR 44

        pop eax
        PRINT_CHAR eax              ; character read in al

        ; ExitProcess(0)
        push    dword 0
        call    _ExitProcess@4
    ;xor eax, eax
    ;ret