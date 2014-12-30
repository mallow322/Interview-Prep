#include <stdio.h>
#include <iostream>
#include <cstring>

char* StrStr(char *str, char *target) {
  if (!*target) return str;
  char *p1 = (char*)str;
  while (*p1) {
    char *p1Begin = p1, *p2 = (char*)target;
    while (*p1 && *p2 && *p1 == *p2) {
      p1++;
      p2++;
    }
    if (!*p2)
      return p1Begin;
    p1 = p1Begin + 1;
  }
  return NULL;
}

char* my_StrStr(char* string, char* sub) {
  if (!sub) return string;
  char* p1 = (char*) string;
  while (*p1) {
    char *p1Begin = p1, *p2 = (char*) sub;
    while (*p1 && *p2 && *p1 == *p2) {
      p1++;
      p2++;
    }
    if (!*p2) return p1Begin;
    p1 = p1Begin + 1;
  }
  return NULL;
}

int main(int argc, char** argv) {
  char string[] = "hello";
  char sub[] = "ll";

  char* match = my_StrStr(string, sub);
  printf("%s\n", match);

  return 0;
}
