(ns code-katas.fizzbuzz-test
  (:require [clojure.test :refer :all]
            [code-katas.fizzbuzz :refer :all]))

(deftest fizzbuzz-test
  (testing "fizzbuzz"
    (is (= "1" (fizzbuzz 1)))
    (is (= "fizz" (fizzbuzz 21)))
    (is (= "buzz" (fizzbuzz 50)))
    (is (= "fizzbuzz" (fizzbuzz 1500)))
    (is (= "buzz" (fizzbuzz 1505)))))
