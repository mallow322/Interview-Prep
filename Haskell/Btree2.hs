data Btree a = Leaf a | Node (Btree a) (Btree a) deriving (Eq, Show)

height :: Btree a -> Int
height (Leaf _) = 0
height (Node t1 t2) = 1 + max (height t1) (height t2)

-- # of leaves
size :: Btree a -> Int
size (Leaf _) = 1
size (Node t1 t2) = size t1 + size t2

-- flatten all of the items at the leaves
flatten :: Btree a -> [a]
flatten (Leaf x) = [x]
flatten (Node t1 t2) = flatten t1 ++ flatten t2

-- map
mapBtree :: (a -> b) -> Btree a -> Btree b
mapBtree f (Leaf x) = Leaf (f x)
mapBtree f (Node t1 t2) = Node (mapBtree f t1) (mapBtree f t2)

-- fold on a Btree using size and flatten
foldBtree f g (Leaf x) = f x
foldBtree f g (Node t1 t2) = g (foldBtree f g t1) (foldBtree f g t2)

-- how to write flatten using foldBtree now?
-- idea is to have f = \x -> [x] and g = (++)
flatten' = foldBtree (\ x -> [x]) (++)

-- how to write height using foldBtree now?
-- f = \ _ -> 0 and g = \ v1 v2 -> 1 + max v1 v2
height' = foldBtree (\ _ -> 0) (\ v1 v2 -> 1 + max v1 v2)

-- reflect a tree
reflect :: Btree a -> Btree a
reflect (Leaf a) = Leaf a
reflect (Node t1 t2) = Node (reflect t2) (reflect t1)
