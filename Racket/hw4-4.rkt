#lang racket
;;give a value and a list
;;returns true if the value is in the list, false otherwise
(define (findVal v myList)
  ;;conditional statement
  (cond
    ;;if the first parameter is a pair,
    ;;then return false
    ((pair? v) #f)
    ;;if the second parameter is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if list is empty,
    ;;then return false
    ((empty? myList) #f)
    ;;if the value of v is equal to the head of the list,
    ;;then return true
    ((eq? v (car myList)) #t)
    ;;else if value of v is not equal to the head of the list,
    ;;then move head to next element
    (else (findVal v (cdr myList)))
   )
  )

;;give a list
;;returns true if there are no repetitions
(define (checkset myList)
  (cond
    ;;if myList is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if myList is empty,
    ;;then return true
    ((empty? myList) #t)
    ;;if head of myList is found in the remainder of the list,
    ;;then return false
    ((findVal (car myList) (cdr myList)) #f)
    ;;else if the head of the list is not found in the remainder,
    ;;then recursively call the function with the rest of myList
    (else (checkset (cdr myList)))
   )
  )