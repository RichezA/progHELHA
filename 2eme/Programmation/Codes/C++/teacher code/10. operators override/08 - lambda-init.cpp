#include <iostream>

using namespace std;

int main()
{
	int x = 4;
	auto f = [&r = x, x = x + 1]()->int
	    {//r is a x-reference, x is incremented
	        r += 2;
	        return x + 2;
	    };//();

	cout << x << endl; //4
	int k = f(); //comment that and uncomment stuff before

	cout << x << endl; //6
	cout << k << endl; //7
}
