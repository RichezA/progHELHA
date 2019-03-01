#include <iostream>

using namespace std;

class FileSystem {

  static FileSystem *singleton;

  string name;

  FileSystem() : name("Windows") {

  }
public:
  static FileSystem* current(){
    if(singleton == NULL) {
      singleton = new FileSystem();
    }
    return singleton;
  }

  string getName(){
    return name;
  }

  void setName(string name) {
    this->name = name;
  }
};

FileSystem* FileSystem::singleton = NULL;


int main(){
  // new FileSystem();
  // FileSystem test;
  cout << FileSystem::current()->getName() << endl;
  FileSystem::current()->setName("OS-X");
  cout << FileSystem::current()->getName() << endl;
}

