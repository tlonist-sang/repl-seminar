(ns WhatIsClojure.greenlabs)
;; file -> project structure -> libraries 에서 참조하고 있는 클로저 jar 파일 경로 확인
;; clojure.jar
;; /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar

;; cors.specs.alpha
;; /Users/tlonist/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar

;; specs.alpha
;; /Users/tlonist/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar

;; 안되는 예시
;; java -jar /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar WhatIsClojure/greenlabs

;; On the fly로 실행시키기
;; java -cp /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar:/Users/tlonist/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/Users/tlonist/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar clojure.main src/WhatIsClojure/greenlabs.clj

;; 컴파일 후 REPL에 EVAL 시키기
;; src 레벨의 WhatIsClojure 컴파일 결과가 있다면 삭제
;; compile.clj ns 에서 실행 (이후 refresh as clojure deps project)
;; src 단에서 아래의 cmd 실행
;; java -cp /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar:/Users/tlonist/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/Users/tlonist/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar:. clojure.main -r
;; (require '[WhatIsClojure.greenlabs :as gr])
;; (gr/hello "Sanghyun")

;; clj -M 으로 실행시키기
;; comment 안에 있는것을 꺼내서 저장

(defn hello [& args]
  (str "Hello " (first args) ", from Greenlabs" \!))

(-> (hello "Sanghyun")
    prn)

(comment
  (-> (hello "Sanghyun")
      prn))


