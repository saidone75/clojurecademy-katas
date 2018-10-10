(ns code-katas.bowling-game)

(defn score
  [game]
  (loop [game game bonus [0 0] score 0 frame 0]
    (cond
      (= 10 frame) (+ score (reduce + (map * bonus game)))
      ; Strike!
      (= 10 (first game))
      (recur
       (drop 1 game)
       (vector (inc (last bonus)) 1)
       (+ score (first game) (* (first bonus) (first game)))
       (inc frame))
      ; Spare
      (= 10 (+ (first game) (second game)))
      (recur
       (drop 2 game)
       (vector (inc (last bonus)) 0)
       (+ score (first game) (second game) (reduce + (map * bonus [(first game) (second game)])))
       (inc frame))
      (> 10 (+ (first game) (second game)))
      (recur
       (drop 2 game)
       (vector (last bonus) 0)
       (+ score (first game) (second game) (reduce + (map * bonus [(first game) (second game)])))
       (inc frame)))))
