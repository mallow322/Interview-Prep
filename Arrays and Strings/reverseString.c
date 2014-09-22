#include <stdio.h>

/*
	Reverse a string
 */

void reverse_string(char*);

int main (int argc, char** argv) {
	printf("The original string is %s\n", argv[1]);
	reverse_string(argv[1]);
	printf("The reversed string is %s\n", argv[1]);
	return 0;
}

void reverse_string(char* str) {
	int length = 0;
	while (*(str+length) != '\0') {
		length++;
	}
	
	char* end = &(str[length-1]);
	char temp;
	while (str < end) {
		temp = *(str);
		*(str) = *(end);
		*(end) = temp;
		str++;
		end--;
	}
}

void reverse_stringV2(char* str) {
	char* end = str;
	char temp;
	if (str) {
		// iterate to the end of the string
		while (*end) {
			++end;
		}
		--end; // go back one char since last char is null terminator

		// swap chars in place starting from far left with the end of the string and then when you meet in the middle, you are done
		while (str < end) {
			temp = *str;
			*str = *end;
			str++;
			*end = temp;
			end--;
		}
	}
}