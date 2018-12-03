// Need to compile with option -std=c++11
#include <iostream>
#include <initializer_list>

using namespace std;

class DataSet
{
	double sum;
	int count;

	public:
		DataSet() : sum(0), count(0) {}

		DataSet(initializer_list<double> data) : DataSet()
		{
			update(data);
		}

		void update(initializer_list<double> data)
		{
			for(double d : data)
			{
				update(d);
			}
		}

		void update(double d)
		{
			sum += d;
			count++;
		}		

		double mean() const
		{
			return sum / count;
		}
};

int main()
{
	DataSet set = {1,2,3};
	cout << set.mean() << endl;
	set.update({4,5,6});
	cout << set.mean() << endl;
}
