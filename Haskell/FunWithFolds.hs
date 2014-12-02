-- sum up a list
sum' :: (Num a) => [a] -> a
sum' xs = foldl (+) 0 xs

elem' :: (Eq a) => a -> [a] -> Bool
elem' x xs = foldl (\acc y -> if x == y then True else acc) False xs
