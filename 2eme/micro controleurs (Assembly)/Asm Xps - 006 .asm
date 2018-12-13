; ----------------------------------------------------------------------------
; Cascio T.
; Asm XPs 006
; Example utilisation SetConsoleTitle 
;there's no real point using printf if you're outputting 
;a fixed string followed by a newline, the puts function is a better choice!
; ----------------------------------------------------------------------------
%include "io.inc"
section .text
global CMAIN
CMAIN:
extern _puts
extern _SetConsoleTitleA@4
extern _SetConsoleMode@8

    Start:

    push Titre1
    call _puts
    add esp,4
    
    push dword 1
    call _SetConsoleMode@8
    Get:
    GET_CHAR edx
    CMP edx,'q'
    JNE Get
    
    xor eax, eax
    ret

section .data
Titre1: db 'Asm Master',0

