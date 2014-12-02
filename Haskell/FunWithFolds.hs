-- sum up a list
sum' :: (Num a) => [a] -> a
sum' xs = foldl (+) 0 xs
-- could use foldl1 which assumes the first element of the list will be the accumulator's starting value
sum'' = foldl1 (+)

-- seeing if an element is in a list
elem' :: (Eq a) => a -> [a] -> Bool
elem' x xs = foldl (\acc y -> if x == y then True else acc) False xs

-- implementing map with a right fold
map' :: (a -> b) -> [a] -> [b] 
map' f xs = foldr (\x acc -> f x : acc) [] xs
-- could have used a left fold, but ++ is an expensive function (moreso than prepending with :)
map'' f xs = foldl (\acc x -> acc ++ [f x]) [] xs

-- finding max in a list
maximum' :: (Ord  a) => [a] -> a
maximum' xs = foldr1 (\x acc -> if x > acc then x else acc) xs
maximum'' xs = foldl1 (\acc x -> if x >= acc then x else acc) xs

reverse' :: [a] -> [a]
reverse' xs = foldl (\acc x -> x : acc) [] xs

product' :: (Num a) => [a] -> a
product' xs = foldl1 (*) xs

filter' :: (a -> Bool) -> [a] -> [a]
filter' p xs = foldr (\x acc -> if p x then x : acc else acc) [] xs

head' :: [a] -> a
head' xs = foldr1 (\x _ -> x) xs

last' :: [a] -> a
last' xs = foldl1 (\_ x -> x) xs

