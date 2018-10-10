(ns code-katas.prime-factors)

(def primes
  (reduce
   #(if (some zero? (map (partial mod %2) %1))
      %1
      (conj %1 %2))
   [2]
   (range 3 1000)))

(defn prime-factors
  [n]
  (loop [n n i 0 factors []]
    (cond (= 0 (mod n (nth primes i)))
          (recur (quot n (nth primes i)) i (conj factors i))
          (> (nth primes i) n)
          (vec (map #(nth primes %) factors))
          :else (recur n (inc i) factors))))
