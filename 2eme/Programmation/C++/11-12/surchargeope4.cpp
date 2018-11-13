class NodeIterator
{
    Node* current;
    public:
        NodeIterator(Node *current): current(current) {}
        int operator *() { return current->data();}
        NodeIterator& operator ++() { current = current->next(); return *this; }
        bool operator !=(const NodeIterator &it) const { return current != it.current; }
};

class LinkedList
{
    Node *head; Node* tail;

    public:
        LinkedList()  : head(nullptr), tail(nullptr) {}
        NodeIterator begin() { return NodeIterator(head); }
        NodeIterator end() { return NodeIterator(nullptr); }
}