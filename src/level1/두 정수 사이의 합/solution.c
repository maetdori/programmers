#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int a, int b) {
    long long answer = 0;
    int i;
    int min;
    int max;
    
    min = a<b ? a:b;
    max = a>b ? a:b;
    
    for(i=min; i<max+1; i++) {
        answer += i;
    }
    
    return answer;
}