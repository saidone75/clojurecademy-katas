(ns code-katas.alphabet-cipher)
(use '[clojure.string :only  [index-of]])

(defn encode-char [k m]
  (let [s "abcdefghijklmnopqrstuvwxyz"]
    (nth (drop (index-of s m) (cycle s)) (index-of s k))))

(defn decode-char [k m]
  (let [s "abcdefghijklmnopqrstuvwxyz"]
    (nth s (index-of (apply str (drop (index-of s k) (take (* 2 (count s)) (cycle s)))) m))))

(defn decipher-char [e m]
  (let [s "abcdefghijklmnopqrstuvwxyz"]
    (nth s (index-of (apply str (drop (index-of s m) (take (* 2 (count s)) (cycle s)))) e))))

(defn encode [keyword message]
  (loop [keyword (take (count message) (cycle keyword))
         message message
         res []]
    (if (empty? keyword)
      (apply str res)
      (recur (rest keyword) (rest message) (conj res (encode-char (first keyword) (first message)))))))

(defn decode [keyword message]
  (loop [keyword (take (count message) (cycle keyword))
         message message
         res []]
    (if (empty? keyword)
      (apply str res)
      (recur (rest keyword) (rest message) (conj res (decode-char (first keyword) (first message)))))))

(defn decipher [cipher message]
  (loop [cipher cipher
         message message
         res []]
    (if (empty? cipher)
      ;puny string loop check
      (loop [res (apply str res) k ""]
        (if (and (= (subs res 0 (count k)) k) (> (count k) 2))
          k
          (recur (subs res 1) (str k (first res)))))
      (recur (rest cipher) (rest message) (conj res (decipher-char (first cipher) (first message)))))))
