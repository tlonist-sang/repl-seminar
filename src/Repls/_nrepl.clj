(ns Repls._nrepl
  (:require [clojure.tools.nrepl :as repl]))



;; nrepl message 의 예시
(comment
  ;; #######################
  ;; port는 뜬 포트로 변경해줘야함
  ;; #######################

  (with-open [conn (repl/connect :port 50006)]
    (-> (repl/client conn 1000)
        (repl/message {:op "eval" :code "(+ 2 3)"})
        repl/response-values))
  (dotimes [n 15] (println "m is " n)(Thread/sleep 500)))


;; session

