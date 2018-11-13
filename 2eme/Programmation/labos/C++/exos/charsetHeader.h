class CharSet
{
    char charArray[255];
    public:
        CharSet();
        ~CharSet();
        void addElement();
        void showSpace();
        void showElement();
        void isElementThere(char elementToCheck);
};