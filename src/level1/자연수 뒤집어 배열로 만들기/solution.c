#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

int* solution(long long n) {
    int* answer = (int*)malloc(12*sizeof(int));
    int i=0;
    
    while(n>0) {
        answer[i] = n % 10;
        n /= 10;
        i++;
    }
    
    return answer;
}