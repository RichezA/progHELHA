#include <iostream>
class Tab
{
    static const int LENGTH = 30;
    char tabs[LENGTH];

  public:
    char &operator[](int index)
    {
        return tabs[index];
    }
    int size() const
    {
        return LENGTH;
    }
};

int main()
{
    Tab tab;
    tab[4] = 'c';
    for (int i = 0; i < tab.size(); i++)
    {
        std::cout << "tab [" << i << "] " << tab[i] << std::endl;
    }
    return 0;
}