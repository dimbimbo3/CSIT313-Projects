#lang racket
;;give intial min and list
;;returns the minimum value in a list
(define (min x myList)
  ;;conditional statement
  (cond
    ;;if the first parameter is a pair,
    ;;then return false
    ((pair? x) #f)
    ;;if the second parameter is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if list is empty,
    ;;then return the value of x as the minimum
    ((empty? myList) x)
    ;;if x is less than the head of the list,
    ;;then recursively call the function
    ;;with x and the remainder of the list
    ((< x (car myList)) (min x (cdr myList)))
    ;;else if the head of the list is less than x,
    ;;then recursively call the function
    ;;with the head of the list and the remainder of the list
    (else (min (car myList) (cdr myList)))
   )
  )

;;give intial max and list
;;returns the maximum value in a list
(define (max x myList)
  ;;conditional statement
  (cond
    ;;if the first parameter is a pair,
    ;;then return false
    ((pair? x) #f)
    ;;if the second parameter is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if list is empty,
    ;;then return the value of x as the maximum
    ((empty? myList) x)
    ;;if x is greater than the head of the list,
    ;;then recursively call the function
    ;;with x and the remainder of the list
    ((> x (car myList)) (max x (cdr myList)))
    ;;else if the head of the list is greater than x,
    ;;then recursively call the function 
    ;;with the head of the list and the remainder of the list
    (else (max (car myList) (cdr myList)))
   )
  )

;;uses the min and max functions
;;returns the largest and smallest numbers in the list
(define (getextremes myList)
  ;;conditional statement
  (cond
    ;;if the parameter is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if list is empty,
    ;;then return false
    ((empty? myList) #f)
    ;;else the paramenter is a list and isn't empty
    ;;then use the head of the list and the remainder of the list
    ;;to call the functions min and max and return the min and max values as a pair
    (else (cons (min (car myList) myList) (max (car myList) myList)))
   )
  )