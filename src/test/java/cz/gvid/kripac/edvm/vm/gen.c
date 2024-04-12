// simple c app to generate some binary files

#include<stdio.h>
#include<stdint.h>

int main(void) 
{
    FILE* f = fopen("test.esm", "wb");
    if (f == NULL) {
        return 1;
    }

    uint8_t first[2] = {0, 4};
    fwrite(&first, sizeof(uint8_t), 2, f);
    uint8_t second[2] = {1, 5};
    fwrite(&second, sizeof(uint8_t), 2, f);
    uint8_t third[2] = {16, 18};
    fwrite(&third, sizeof(uint8_t), 2, f);

    fclose(f);
}
