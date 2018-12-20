%include "io.inc"

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
    ;extern _GetStdHandle@4
    xor eax, eax
    xor ecx, ecx
    xor ebx, ebx
    xor edx, edx
    JMP getString


getString:
    PRINT_STRING begin          ; std::cout << begin;
    NEWLINE                     ; std::endl;
    GET_STRING written, 256     ; std::cin >> string;
    mov ecx, written   
    
getIndex: 
   PRINT_STRING msg
   GET_UDEC 4, edx 
   NEWLINE
         

getStrLength:
    push ecx               
    mov byte[number], 0            ; number of chars int nbChars = 0;
    mov byte[index], 0             ; numbers of commas int comma = 0;
    dec ecx                        ; char *input
    count:                         ; *for(int i = 0; i < string.length(); i++)
        cmp edx, eax              ; eax = number of commas, ebx = adress of value
        jz endProcess
        PRINT_CHAR [ecx]
        inc byte[number]           ; nbChars++;
        inc ecx                    ; string(i)
        cmp byte[ecx], ','         ; if(string.at(i) == ',')
        je showVirgule
        cmp byte[ecx], 0            ; if(string.at(string.end()))
        jnz count
endProcess:
    dec byte[number]
    pop ecx     ; for stack overflows   

showString:
    ;NEWLINE
    ;PRINT_STRING [ecx]        ; jusque ecx
    ;prints the number of chars
    ;NEWLINE
    ;PRINT_STRING nbCaract
    ;PRINT_DEC 4, [number]
    ret   
 
 
showVirgule:
    inc eax         ; numbers of commas
    JMP count 

    xor eax, eax
    xor ebx, ebx
    xor ecx, ecx
    ret
    
section .data
    begin: dd "Rentrez votre phrase en délimitant les mots avec des virgules",0
    nbCaract: dd "Nb de caractères : "
    msg: dd "Index ?", 0
section .bss
    number: resw 1
    index: resw 1
    written: resb 1
    ID: resw 1
    