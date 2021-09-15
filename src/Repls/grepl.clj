(ns Repls.grepl)

;; java -cp /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar:/Users/tlonist/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/Users/tlonist/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar:./src -Dclojure.server.repl="{:port 5555 :accept Repls.grepl/g-repl}" clojure.main
;; java -cp clojure-1.10.1.jar:spec.alpha-0.2.176.jar:core.specs.alpha-0.2.44.jar:./src -Dclojure.server.repl="{:port 5555 :accept Repls.grepl/g-repl}" clojure.main
;; *주의* classpath에 :./src 가 있어야함
;; telnet 127.0.0.1 5555

(defn g-read []
  (print "grepl:: ")
  (flush)
  (read-line))

(defn g-repl []
  (loop [input (g-read)]
    (let [count (-> input
                    count)]
     (println "code-length:" count ", result:" (eval (read-string input))))
    (recur (g-read))))



