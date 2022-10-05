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
;;returns the list with any duplicate values removed
(define (removeDupes myList)
  (cond
    ;;if myList is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if myList is empty,
    ;;then return an empty list
    ((empty? myList) '())
    ;;if head of myList is found in the remainder of the list,
    ;;then recursively call the function with the remainder of the list
    ((findVal (car myList) (cdr myList)) (removeDupes (cdr myList)))
    ;;else if the head of the list is not found in the remainder,
    ;;then construct a pair with the head of the list and
    ;;the recursive call of the function with the remainder of the list
    (else (cons (car myList) (removeDupes (cdr myList))))
   )
  )

;;give two lists
;;returns the union of both lists
(define (unite list1 list2)
  (cond
    ;;if list1 is not a list,
    ;;then return false
    ((not (list? list1)) #f)
    ;;if list2 is not a list,
    ;;then return false
    ((not (list? list2)) #f)
    ;;else both parameters are lists,
    ;;then calls the function removeDupes with
    ;;a new list containing the elements of both list1 and list2
    (else (removeDupes (append list1 list2)))
   )
  )