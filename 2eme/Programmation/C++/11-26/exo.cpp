#include <iostream>

class LinkedList
{
    double dbl;
    LinkedList *nextadr;

  public:
    LinkedList(double db, LinkedList *adr = nullptr) : dbl(db), nextadr(adr) {}
    double squared()
    {
        dbl *= dbl;
        return dbl;
    }
    double sum()
    {
        this->squared();
        if (nextadr == nullptr)
            return dbl;
        return nextadr->sum() + dbl;
    }
    LinkedList *insert(double value)
    {
        if (dbl < value)
        {
            if (nextadr == nullptr || nextadr->dbl > value)
            {
                LinkedList *tmp = nextadr;
                nextadr = new LinkedList(value, tmp);
                return nullptr; // cuz we don't modify head
            }
            else
            {
                nextadr->insert(value);
                return nullptr;
            }
        }
        else
        {
            return new LinkedList(value, this);
        }
    }
    LinkedList &operator++();
    LinkedList &operator++(int);
};

LinkedList &LinkedList::operator++()
{
    std::cout << "prefix" << std::endl;
    dbl++;
    return *this;
}
LinkedList &LinkedList::operator++(int)
{
    std::cout << "suffix" << std::endl;
    LinkedList r = *this;
    operator++();
    return r;
}

int main()
{

    LinkedList *head = new LinkedList(5.5);
    std::cout << head->sum() << std::endl;
    head->insert(10);
    std::cout << head->sum() << std::endl;
    head = head->insert(2);
    std::cout << head->sum() << std::endl;
    LinkedList &objHead = *head;
    objHead++;
    ++objHead;
    return 0;
}