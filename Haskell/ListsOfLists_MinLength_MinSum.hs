import Data.Function
import Data.List
import Prelude

test_lists = [[1, 2], [3, 4, 5], [6, 7, 8, 9]]

-- Given a list of lists (test case above), give the list with the min length
minList xss = minimumBy (compare`on`length) xss

