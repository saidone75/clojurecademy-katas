(ns code-katas.prime-factors-test
  (:require [clojure.test :refer :all]
            [code-katas.prime-factors :refer :all]))

(deftest prime-factors-test
  (testing "prime-factors"
    (is (= (prime-factors 2) [2]))
    (is (= (prime-factors 3) [3]))
    (is (= (prime-factors 4) [2 2]))
    (is (= (prime-factors 6) [2 3]))
    (is (= (prime-factors 8) [2 2 2]))
    (is (= (prime-factors 9) [3 3]))
    (is (= (prime-factors 10) [2 5]))
    (is (= (prime-factors 60) [2 2 3 5]))))
