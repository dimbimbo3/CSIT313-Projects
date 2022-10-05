#lang racket
;;determines if the variable is an atom
(define (atom? var)
   ;;conditional statement
  (cond
    ;;if the variable is not a pair,
    ;;then return true
    ((not (pair? var)) #t)
    ;;else if the variable is a pair,
    ;;then return false
    (else #f)
   )
  )

;;deletes all occurences of the atom in the list
(define (delall atom myList)
  ;;conditional statement
  (cond
    ;;if first parameter is not an atom,
    ;;then return false
    ((not (atom? atom)) #f)
    ;;if second parameter is not a list,
    ;;then return false
    ((not (list? myList)) #f)
    ;;if list is empty,
    ;;return empty list
    ((empty? myList) '())
    ;;if the value of atom is equal to the
    ;;head of the list, then recursively
    ;;call the function with the tail of the list
    ((eq? atom (car myList)) (delall atom (cdr myList)))
    ;;if the head of the list is a pair,
    ;;then construct a pair from the
    ;;recursive function call of the head
    ;;and the recursive function call of the tail of the list
    ((pair? (car myList)) (cons (delall atom (car myList)) (delall atom (cdr myList))))
    ;;else the value of atom is not equal to the
    ;;head, then construct a pair from the head
    ;;and the recursive function call of the tail of the list
    (else (cons (car myList) (delall atom (cdr myList))))
   )
  )