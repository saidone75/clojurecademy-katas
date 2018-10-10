(ns code-katas.bowling-game-test
  (:require [clojure.test :refer :all]
            [code-katas.bowling-game :refer :all]))

(deftest bowling-game-test
  (testing "score"
    (is (= (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]) 0))
    (is (= (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]) 20))
    (is (= (score [5 5 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]) 16))
    (is (= (score [10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]) 24))
    (is (= (score [10 10 10 10 10 10 10 10 10 10 10 10]) 300))
    (is (= (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 10]) 155))
    (is (= (score [0 0 10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0]) 24))))
