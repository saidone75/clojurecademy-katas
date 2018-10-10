(ns code-katas.fizzbuzz)

(defn fizzbuzz
  [n]
  (cond
    (= 0 (mod n 15)) "fizzbuzz"
    (= 0 (mod n 3)) "fizz"
    (= 0 (mod n 5)) "buzz"
    :else (str n)))
