{-	Concatenation of lists/strings and unconcatenation of a string with delimiters
	Dan Imbimbo		September 23, 2020
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

--adds a character delimiter to end of each string in a list of strings (a helper function to be used by concatStringsUsingDelimiter)
addDelimiter :: a -> [[a]] -> [[a]] -- :type
addDelimiter dl [] = []
addDelimiter dl (x:xs) = concatenate x [dl] : addDelimiter dl xs

--constructs a single string from a list of strings via the foldl function, with a delimiter inbetween each concatenated string
concatStringsUsingDelimiter :: a -> [[a]] -> [a] -- :type
concatStringsUsingDelimiter dl [] = []
concatStringsUsingDelimiter dl (xs) = foldl (concatenate) [] (addDelimiter dl xs)

--seperates a string into a list of strings at the specified delimiters
unconcatStringWithDelimiter :: Char -> String -> [String] -- :type
unconcatStringWithDelimiter dl [] = []
unconcatStringWithDelimiter dl (x:xs)  | x == dl = "" : remaining                                       | otherwise = (x : head remaining) : tail remaining                   where remaining = unconcatStringWithDelimiter dl xs