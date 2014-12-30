module Tree where 

import qualified Data.Foldable as F

data Tree a = Empty | Node a (Tree a) (Tree a) deriving (Eq, Show)

 -- a few Binary trees for examples
t0 = Empty -- empty Btree
t1 = Node 1 Empty Empty -- a Btree with just a root and two empty subtrees
t3 = Node 2 (Node 1 Empty Empty) (Node 3 Empty Empty) -- a three Node tree

-- To write a traversal, we fold a binary operator f through the values in the tree, starting with an 
-- initial accumulator value of z.

----------------------------------------
--- PRE ORDER TRAVERSAL ---
--- 1) Visit the current root  ---
--- 2) Visit the left subtree   ---
--- 3) Visit the right subtree ---
----------------------------------------
preorder_traversal f z tree = go tree z
  where 
    go Empty z = z
    go (Node n left right) z = 
      let z' = f n z            -- current node
          z'' = go left z'      -- left subtree
          z''' = go right z''  -- right subtree
      in z'''

----------------------------------------
--- IN ORDER TRAVERSAL    ---
--- 1) Visit the left subtree   ---
--- 2) Visit the current root  ---
--- 3) Visit the right subtree ---
----------------------------------------
inorder_traversal f z tree = go tree z 
  where
    go Empty z = z
    go (Node n left right) z = 
      let z' = go left z      -- left subtree
          z'' = f n z'           -- current node
          z''' = go right z'' -- right subtree
      in z'''

flatten traversal = reverse . traversal (:) []
test0_preorder = flatten preorder_traversal t3 -- [2, 1, 3]
test0_inorder = flatten inorder_traversal t3 -- [1, 2, 3]

-- A more generic traversal function.  Instead of implementing post-order traversal, let's try to generalize.
traverse step f z tree = go tree z 
  where 
    go Empty z = z
    go (Node val left right) z = step (f val) (go left) (go right) z

preorder = traverse (\n left right -> right . left . n)
inorder = traverse (\n left right -> right . n . left)
postorder = traverse (\n left right -> n . right . left)

test1_preorder = flatten preorder t3
test1_inorder = flatten inorder t3
test1_postorder = flatten postorder t3

-- Now, let's use the general traverse function we made for finding the min and max in a BST
leftOrder = traverse (\n left right -> left . n)
rightOrder = traverse (\n left right -> right . n)
