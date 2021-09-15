(ns ReplDriven.addlibs)

(comment
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])
  (add-libs '{ring/ring {:mvn/version "RELEASE"}})
  (take 25 (iterate (fn [_] (rand-int 100)) (rand-int 100)))

  (sort (map #(str `~%) (all-ns)))
  ,)
