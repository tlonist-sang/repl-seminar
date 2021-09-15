(ns WhatIsClojure.hello
  (:gen-class))
;; compile.clj가 comment 밖에 있어서 문제가 되었음 (main을 못찾음)
;; gen-class 설명
;; clj -M:uberjar
;; java -jar target/greenlabs-seminar-1.0.0-SNAPSHOT-standalone.jar

(defn hello [name]
  (str "Hello " name ", from Greenlabs" \!))

(defn -main []
  (-> (hello "Sanghyun")
      println))
