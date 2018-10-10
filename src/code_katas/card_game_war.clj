(ns code-katas.card-game-war)

(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards (for [suit suits rank ranks]
             [suit rank]))

(defn play-round
  [player1-card player2-card]
  (cond
    (> (.indexOf ranks (second player1-card)) (.indexOf ranks (second player2-card)))
    [[player1-card player2-card] []]
    (< (.indexOf ranks (second player1-card)) (.indexOf ranks (second player2-card)))
    [[] [player2-card player1-card]]
    (> (.indexOf suits (first player1-card)) (.indexOf suits (first player2-card)))
    [[player1-card player2-card] []]
    :else [[] [player2-card player1-card]]))

(defn play-game
  [player1-cards player2-cards]
  (loop [player1-cards player1-cards player2-cards player2-cards]
    (cond
      (empty? (first player1-cards)) :player2
      (empty? (first player2-cards)) :player1
      :else
      (let [round (play-round (first player1-cards) (first player2-cards))]
        (recur
         (vec (concat (rest player1-cards) (first round)))
         (vec (concat (rest player2-cards) (second round))))))))
