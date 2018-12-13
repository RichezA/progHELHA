#include <iostream>
#include <vector>
#include <algorithm>

class Tada
{
  public:
    void operator()(int n)
    {
        std::cout << "Tada " << n << std::endl;
    }
};

void f(int &n)
{
    std::cout << "Applying f on " << n << std::endl;
}

bool inequal(int n)
{
    return n % 2 == 1;
}

int main()
{
    Tada t;
    t(5);

    std::vector<int> v = {1, 2, 3, 4, 5, 6};
    std::for_each(v.begin(), v.end(), f);
    std::cout << std::endl;

    std::for_each(v.begin(), v.end(), Tada());
    std::cout << std::endl;

    auto result = std::find_if(v.begin(), v.end(), inequal);
    while (result != v.end())
    {
        std::cout << *result << std::endl;
        result++;
    }
}