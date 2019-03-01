#include <vector>
#include <iostream>

using namespace std;

class Tada //try to remove default cstr
{
	public:
		void operator () (int n)
		{
			cout << "Tada " << n << endl;
		}
};

void f(int& n)
{
	cout << "Applying f on " << n << endl;
}

bool impair(int n)
{
	return n % 2 == 1;
}

int main()
{	
	Tada t;
	t(5);

	vector<int> v = {1, 2, 3, 4, 5, 6};	
	for(int i = 0; i < 6; i++) {
		cout << v[i] << endl;
	}
	for_each(v.begin(), v.end(), f);
	cout << endl;

	for_each(v.begin(), v.end(), Tada()); //try to build Tada before
	cout << endl;

	// auto result = find_if(v.begin(), v.end(), impair);
	// while(result != v.end())
	// {
	// 	cout << *result << endl;
	// 	result++;
	// }
}
