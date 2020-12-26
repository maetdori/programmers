#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(long long n) {
    long long answer = 0;
    long long x = 1;
    
    while(1) {
        if(x>n) {
            answer = -1;
            break;
        }
        else if (n%x == 0 && n/x == x) {
            answer = (x+1)*(x+1);
            break;
        }
        x++;
    }
    return answer;
}