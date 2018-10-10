(ns code-katas.card-game-war-test
  (:require [clojure.test :refer :all]
            [code-katas.card-game-war :refer :all]))

(deftest card-game-war-test
  (testing "play-round")
  (is (= [[[:spade 4] [:spade 2]] []]
         (play-round [:spade 4] [:spade 2])))
  (is (= [[] [[:spade 4] [:spade 2]]]
         (play-round [:spade 2] [:spade 4])))
  (is (= [[[:spade :queen] [:spade :jack]] []]
         (play-round [:spade :queen] [:spade :jack])))
  (is (= [[[:spade :king] [:spade :queen]] []]
         (play-round [:spade :king] [:spade :queen])))
  (is (= [[[:spade :ace] [:spade :king]] []]
         (play-round [:spade :ace] [:spade :king])))
  (is (= [[[:club 2] [:spade 2]] []]
         (play-round [:club 2] [:spade 2])))
  (is (= [[[:diamond 2] [:club 2]] []]
         (play-round [:diamond 2] [:club 2])))
  (is (= [[[:heart 2] [:diamond 2]] []]
         (play-round [:heart 2] [:diamond 2])))
  (let [win-start [[:heart 10]] lose-start [[:heart 9]]]
    (is (= :player1 (play-game win-start lose-start)))
    (is (= :player2 (play-game lose-start win-start)))))
