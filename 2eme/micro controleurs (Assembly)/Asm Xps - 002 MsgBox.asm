%include "io.inc"

section .text
global CMAIN
extern _MessageBoxA@16

CMAIN:
    push 00h   ; information icon
;MB_OK                  equ 0h
;MB_OKCANCEL            equ 1h
;MB_ABORTRETRYIGNORE    equ 2h
;MB_YESNOCANCEL         equ 3h
;MB_YESNO               equ 4h
;MB_RETRYCANCEL         equ 5h
    push msg
    push msg2
    ;push dword msg_L
    push 0
    call _MessageBoxA@16
    xor eax, eax
    ret
    
section .data ;Constant
            msg:    db "Erreur",34  ;ASCII val 34 replace by 0  just to show
            msg_L:   equ $-msg  ; Current - msg1

            msg2:   dw "Stop"
            msg2_L: equ $-msg2;