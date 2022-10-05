/*
Dan Imbimbo
5/5/21
*/

/*If the function (last) recieves a list (with a head & a tail),
then recursively calls the function with the tail as the list*/
last([HEAD|TAIL]) :- last(TAIL).
/*If the function (last) recieves a list that has only one element,
then write that element to the output*/
last([VAL]) :- write("Last="), write(VAL).




