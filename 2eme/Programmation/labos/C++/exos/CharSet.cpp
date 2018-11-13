#include "charsetHeader.h"
#include <iostream>
#include <cstring>

        CharSet::CharSet() {}
        CharSet::~CharSet() {}
        void CharSet::addElement()
        {
            char element[255];
            std::cout << "What is the element that you want to add ? ";
            std::cin >> element;
            while(std::cin.fail())
            {
                std::cin.clear();
                std::cin.ignore(1000000, '\n');
                std::cout << "Please enter a valid element " << std::endl;
                std::cin >> element;
            }
            int size = std::strlen(element);
            //std::cout << size << std::endl;
            if(std::strlen(charArray) < 255) 
            {
                for(int i = 0; i <= size; i++)
                {
                    charArray[i] = element[i];
                }
            }
        }
        void CharSet::showSpace()
        {
            std::cout << "there's " << std::strlen(charArray) << " characters in the array" << std::endl;
        }
        void CharSet::showElement()
        {
            for(int i = 0; i < std::strlen(charArray);i++)
            {
                std::cout << charArray[i];
            }
            std::cout << std::endl;
        }
        void CharSet::isElementThere(char elementToCheck)
        {
            bool isThere = false;
            for(int i = 0; i < std::strlen(charArray); i++)
            {
                if(elementToCheck == charArray[i]) 
                {
                    std::cout << "There's the char you're searching for at the index " << i << std::endl;
                }
            }
        }