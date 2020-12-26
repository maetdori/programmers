#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(int x) {
    bool answer = true;
    int div = 10;
    int sum = 0;
    int n = x;
    while(n>0) {
        sum += n%div;
        n /= div;
    }
    if(x % sum == 0)
        answer = true;
    else answer = false;
    return answer;
}