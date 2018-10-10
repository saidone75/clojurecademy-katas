(ns code-katas.tiny-maze-test
  (:require [clojure.test :refer :all]
            [code-katas.tiny-maze :refer :all]))

(deftest tiny-maze-test
  (testing "solve-maze"
    (let  [maze  [[:S 0 1]
                  [1 0 1]
                  [1 0 :E]]
           sol  [[:x :x 1]
                 [1 :x 1]
                 [1 :x :x]]]
      (is (= sol  (solve-maze maze))))
    (let  [maze  [[:S 0 0 1]
                  [1 1 0 0]
                  [1 0 0 1]
                  [1 1 0 :E]]
           sol  [[:x :x :x 1]
                 [1 1 :x 0]
                 [1 0 :x 1]
                 [1 1 :x :x]]]
      (is  (= sol  (solve-maze maze))))))

(def test-maze [[:S 0 0 0 0]
                [1 0 0 0 0]
                [1 0 0 0 0]
                [0 0 1 0 1]
                [0 1 0 :E 0]])

(defn pretty-print [maze]
  (map #(println (clojure.string/replace % #":x" "x")) maze))

(pretty-print (solve-maze test-maze))
