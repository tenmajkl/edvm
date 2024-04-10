# edvm

Simple virtual machine implemented in Java with graphical representation of what happens inside. MOre of this will be in czech as it is school project 

Aplikace bude rozdělena na tři části -- VM, jazyk symbolických instrukcí a grafická část.

## VM 

- VM bude pracovat s polem instrukcí a 4 třmídami reprezentujícími registry, paměť, standardní vstup a výstup. Jednotlivé instrukce se budou spouštět postupně pomocí funkce `evalNext`
- 16b instrukce 
- 16 instrukcí 
- 256 paměťových buněk s 8b čísly
- 16 registrů s 8b čísly
- aritmetika
- systémová volání (čtení, výpis, ...)

### Bytecode 

- první 4 b jsou pro instrukci
- zbylých 12 b je pro argumenty
- využití bitových operací pro parsování
- maximálně 64 instrukcí (=> 10B soubor)

### Instrukce 

| Kód  | Název pro ASM | Argumenty                               | Popis                                                                                                                     |
|------|---------------|-----------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| 0000 | srv           | register (4 b) value (8 b)              | nastaví hodnotu do registru                                                                                               | 
| 0001 | add           | register1 register2 register3 (vše 4 b) | sečte hodnoty v prvních 2 registrech a výsledek vloží do třetího registru                                                 |
| 0010 | sub           | register1 register2 register3 (vše 4 b) | odečte hodnoty v prvních 2 registrech a výsledek vloží do třetího registru                                                |
| 0011 | mul           | register1 register2 register3 (vše 4 b) | vynásobí hodnoty v prvních 2 registrech a výsledek vloží do třetího registru                                              |
| 0100 | div           | register1 register2 register3 (vše 4 b) | vydělí hodnoty v prvních 2 registrech a výsledek vloží do třetího registru                                                |
| 0101 | or            | register1 register2 register3 (vše 4 b) | vloží hodnotu 1 do registru 3 v případě, že je v alespoň jednom registru nenulová hodnota, jinak vloží nulu               |
| 0110 | not           | register (4 b)                          | nenulovou hodnotu v registru nahradí za nulovou a vice versa                                                              |
| 0111 | and           | register1 register2 register3(vše 6 b)  | vloží hodnotu 1 do registru 3 v případě, že je v obou registrech nenulová hodnota, jinak vloží nulu                       |
| 1000 | jmp           | position (6 b)                          | skočí na danou instrukci                                                                                                  |
| 1001 | jrz           | register (4 b) position (6 b)           | skočí na danou instrukci pouze tehdy, pokud je v daném registru hodnota 0                                                 |
| 1010 | set           | position (8 b) register (4 b)           | Vloží hodnotu z registru na danou pozici na paměťové pásce                                                                |
| 1011 | get           | position (8 b) register (4 b)           | Vloží hodnotu z dané pozice na pásce do daného registru                                                                   |
| 1100 | sys           | register1 register2 register3 (vše 4 b) | zavolá syscall jehož id je v registru 1 s hodnotou z registru 2 a výsledek vloží do registru 3                            |
| 1101 | equ           | register1 register2 register3 (vše 4 b) | porovná hodnoty v prvních dvou registrech a pokud jsou stejné, vloží nenulovou hodnotu do třetího registru, jinak nulu    |
| 1110 | st            | register1 register2 register3 (vše 4 b) | porovná hodnoty v prvních dvou registrech a pokud je první menší, vloží nenulovou hodnotu do třetího registru, jinak nulu |
| 1111 | gt            | register1 register2 register3 (vše 4 b) | porovná hodnoty v prvních dvou registrech a pokud je první větší, vloží nenulovou hodnotu do třetího registru, jinak nulu |


## Jazyk symbolických instrukcí 

- načítán ze souboru
- kromě přímých ekvivalentů binárních reprezentací instrukcí bude obsahovat také labely, které nebudou překládány, jejich použití se přeloží na korespondující řádek
- bude generovat binárku jako pole pro VM a pole, kde budou korespondující instrukce vedle sebe 

## Debugger aplikace

- bude umožnovat chodit krok po kroku instrukci po instrukci 
- assembler bude mít vedle sebe i binárku
- vedle bude vidět paměť a registry 
- dole bude terminál
