#include <stdio.h>
 int main(void) {
   int x;
   int y;
   int* p;

   x=13;
   y=0;

   p=&x;
   y=*p;

   printf("Value of x=%d ",x);
   printf("Adress of x=%p",&x);
   printf("\n");

   printf("Value of p=%p ",p);
   printf("Adress of p=%p",&p);
   printf("\n");

   printf("Value of y=%d ",y);
   printf("Adress of y=%p",&y);
   printf("\n");

   return 0;
 }