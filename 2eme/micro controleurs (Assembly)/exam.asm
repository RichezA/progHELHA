%include "io.inc"

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
    ;extern _GetStdHandle@4

    JMP getString


getString:
    PRINT_STRING begin          ; std::cout << begin;
    NEWLINE                     ; std::endl;
    GET_STRING written, 256     ; std::cin >> string;

    
getIndex:
   xor eax, eax        ;nbr of commas
   xor ecx, ecx        ;input
   xor ebx, ebx        ;last adress
   xor edx, edx        ;index value
   mov ecx, written
   mov ebx, ecx    
   NEWLINE
   PRINT_STRING msg
   GET_UDEC 4, edx 
   NEWLINE
   cmp edx, 0
   JE quit
         

getStrLength:
    push ecx                 
    dec ecx                        ; real time char
    count:                         ; *for(int i = 0; i < string.length(); i++)
        cmp edx, eax              ; eax = number of commas, edx = adress of value
        jz endProcess
        ;PRINT_CHAR [ecx]
        inc ecx                    ; real time char
        cmp byte[ecx], ','         ; if(string.at(i) == ',')
        je showVirgule
        cmp byte[ecx], 0            ; if(string.at(string.end()))
        jnz count
endProcess:
    PRINT_CHAR[ebx]
    inc ebx
    cmp ebx, ecx        ; 
    JNE endProcess
    pop ecx     ; for stack overflows   

   
JMP getIndex

quit:
    xor eax, eax
    xor ebx, ebx
    xor ecx, ecx
    xor edx, edx
    ret

showVirgule:
    inc eax         ; numbers of commas
    cmp edx, eax
    JNE getAddress
    JMP count 

getAddress:
     mov ebx, ecx
     JMP count
    
section .data
    begin: dd "Rentrez votre phrase en d�limitant les mots avec des virgules",0
    msg: dd "Index ?, 0 pour quitter ", 0
section .bss
    written: resb 1