; ----------------------------------------------------------------------------
; Cascio T.
; Asm XPs 003
; Example utilisation SetConsoleTitle 
;La pile est une zone de mémoire permettant de stocker et retrouver rapidement des valeurs pour :

;    Placer des variables locales dans un sous-programme,
;    Sauvegarder l'adresse de retour (fait par les instructions CALL, INT),
;    Transmettre les arguments à un sous-programme.
; ----------------------------------------------------------------------------
%include "io.inc"

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
extern  _SetConsoleTitleA@4

    Start:

    push Titre1
    call _SetConsoleTitleA@4
    Get:
    GET_CHAR edx
    CMP edx,'q'
    JNE Get
    
    xor eax, eax
    ret

section .data
Titre1: db 'Asm Master',0
len1: equ $- Titre1
