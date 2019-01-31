package utilites;

import fighters.base.Fighter;

class Fatum

{
   private Fighter first;
   private Fighter second;

   void saveState(Fighter d1, Fighter d2) {
       first = d1;
       second = d2;
   }

    Fighter getFirst() {
       return first;
   }

    Fighter getSecond() {
       return second;
   }
}
