{-	Concatenation of lists
	Dan Imbimbo		September 11, 2020
-}

import Data.List

--constructs a single list from two seperate lists
concatenate :: [a] -> [a] -> [a] -- :type
concatenate [] zs = zs
concatenate (x:xs) ys = x : concatenate xs ys

--constructs a single list from one list of lists via pattern matching and recursion
concatList :: [[a]] -> [a] -- :type
concatList [] = []
concatList ((x:xs):xss) = x : concatenate xs (concatList xss)

--constructs a single list from one list of lists via the foldl function
concatList' :: [[a]] -> [a] -- :type
concatList' [] = []
concatList' (xss) = foldl (concatenate) [] (xss)
