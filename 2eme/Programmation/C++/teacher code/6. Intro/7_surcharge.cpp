#include <stdio.h>

double exemple(double x, double w){ // configuration -A-  
  printf("configuration -A-:%f %f \n",x,w);
  return x;
}
int exemple(int x, int w){ // configuration -B-
  printf("configuration -B-:%d %d \n",x,w);
  return x;
}
int exemple(double x, int w){ // configuration -C-
  printf("configuration -C-:%f %d \n",x,w);
  return x;
}
int main() {
  int b=200,v;
  double a=100.5, w;
  // essayer sans les cast
  v = exemple((double) b, a);
  w = exemple(b, (int) a);
  w = exemple(a, b);
  w = exemple(b, 'c');
  w = exemple(b, true);
  w = exemple(b, b);
  return 0;
}
