import qualified Data.Foldable as F

-- With making our Tree data type an instance of Foldable, we'll be able to use every function
-- that works on Foldable types, such as elem, foldr,foldl, sum, minimum, and maximum.

data Tree a = Leaf a | Node a (Tree a) (Tree a) deriving (Eq, Show)

-- Pre-order visit
instance F.Foldable Tree where
    foldr f z (Leaf x) = f x z
    foldr f z (Node k left right) = f k (F.foldr f (F.foldr f z right) left)

testTree = Node 1 (Node 2 (Leaf 3) (Leaf 4)) (Leaf 5)
listTree = F.toList testTree
