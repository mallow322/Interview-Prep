#include <iostream>

std::string compressString(std::string str) {
	if (str.empty()) return str;

	int count = 1;
	std::string compressedStr, current;
	char buffer[256];

	for (int i = 0; i < str.length(); i++) {
		count = 1; // always have at least one occurrence of that character we're looking at
		current = str[i];
		while (str[i] == str[i+1]) {
			count++;
			i++;
		}

		compressedStr.append(current);
		// write formatted data to string (i.e. write the count (an int) -> string using our buffer)
		std::sprintf(buffer, "%d", count);
		compressedStr.append(buffer);
	}

	// return the compressed string if it's shorter than the original
	return (compressedStr.length() >= str.length()) ? str : compressedStr;
}


int main(int argc, const char* argv[]) {
	// test cases
	char const* strArray[] = {"aabcccccaaa", "aaaaa", "abc", "aabbcc", "", NULL};
    std::string compressedStr;

    for (int i = 0; strArray[i] != NULL; i++) {
      std::cout << "Original string: " << strArray[i] << std::endl;
      std::cout << "Processed string: " << compressString(strArray[i]) << std::endl;
    }

    return 0;
}
