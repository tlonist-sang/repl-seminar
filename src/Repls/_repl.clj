(ns Repls._repl)


(comment
  (take 100 (iterate (fn [_] (rand-int 1000)) (rand-int 1000)))
  (dotimes [y 5]
    (println (map #(inc %) (range (inc  y))))
    (Thread/sleep 500))
  ,)
