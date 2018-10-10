(ns code-katas.tiny-maze)

(defn find-neighbours [x maze]
  (let [w (count (first maze)) l (count (flatten maze))]
    (->> [(dec x) (inc x) (- x w) (+ x w)]
         (filter #(and (> % -1) (< % l)))
         (filter #(not (= 1 (nth (flatten maze) %))))
         (filter #(not (= :x (nth (flatten maze) %)))))))

(defn find-start [maze]
  (.indexOf (flatten maze) :S))

(def solutions (atom {}))

(defn solve-maze-helper [maze pos steps]
  (let [w (count (first maze))]
    (if (= :E (nth (flatten maze) pos))
      (reset! solutions
              (assoc @solutions steps (partition w (flatten (list (take pos (flatten maze)) :x (drop (inc pos) (flatten maze))))))))
    (doseq [neighbour (find-neighbours pos maze)]
      (solve-maze-helper
       (partition w (flatten (list (take pos (flatten maze)) :x (drop (inc pos) (flatten maze)))))
       neighbour
       (inc steps)))))

(defn solve-maze
  [maze]
  (reset! solutions {})
  (solve-maze-helper maze (find-start maze) 0)
  (vec (for [x  (get @solutions (apply min (keys @solutions)))]
         (vec x))))
