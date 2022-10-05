/*
Dan Imbimbo
5/5/21
*/


/*If function (max) recieves only a list (with a head & a tail),
then call the two argument max function (max2)
with the tail as the list and the head as the max*/
max([HEAD|TAIL]) :- max2(TAIL, HEAD).
/*If function (max2) recieves a list (with a head & a tail) and a max value,
then if the head is greater than or equal to that max recursively call
the function with the tail as the list and the head as the new max,
else recursively call the function with the tail as the list and the old max*/
max2([HEAD|TAIL], MAX) :- (HEAD >= MAX -> max2(TAIL, HEAD); max2(TAIL, MAX)).
/*If function (max2) recieves an empty list and a max value,
then write the max value to the output*/
max2([], MAX) :- write("Max="), write(MAX).
