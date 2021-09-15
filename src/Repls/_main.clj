(ns Repls.-main)

;; clojure.main 찾는 방법 => clojure.core/아무거나 로 가서 main.clj

;; 코드 즉석 eval 해보기
;; java -cp /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar:/Users/tlonist/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/Users/tlonist/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar:. clojure.main -e "(+ 1 2)"
;; java -cp /Users/tlonist/.m2/repository/org/clojure/clojure/1.10.1/clojure-1.10.1.jar:/Users/tlonist/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/Users/tlonist/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar:. clojure.main -e "((fn [name] (str \"Hello, \" name \\!)) \"World\")"

(comment
  (defn main
    "Usage: java -cp clojure.jar clojure.main [init-opt*] [main-opt] [arg*]

    With no options or args, runs an interactive Read-Eval-Print Loop

    init options:
      -i, --init path     Load a file or resource
      -e, --eval string   Evaluate expressions in string; print non-nil values
      --report target     Report uncaught exception to \"file\" (default), \"stderr\",
                          or \"none\", overrides System property clojure.main.report

    main options:
      -m, --main ns-name  Call the -main function from a namespace with args
      -r, --repl          Run a repl
      path                Run a script from a file or resource
      -                   Run a script from standard input
      -h, -?, --help      Print this help message and exit

    operation:

      - Establishes thread-local bindings for commonly set!-able vars
      - Enters the user namespace
      - Binds *command-line-args* to a seq of strings containing command line
        args that appear after any main option
      - Runs all init options in order
      - Calls a -main function or runs a repl or script if requested

    The init options may be repeated and mixed freely, but must appear before
    any main option. The appearance of any eval option before running a repl
    suppresses the usual repl greeting message: \"Clojure ~(clojure-version)\".

    Paths may be absolute or relative in the filesystem or relative to
    classpath. Classpath-relative paths have prefix of @ or @/"
    [& args]
    (try
      (if args)
      (loop [[opt arg & more :as args] args, inits [], flags nil])
      (cond)
      ;; flag
      (contains? #{"--report"} opt)
      (recur more inits (merge flags {(subs opt 2) arg}))

      ;; init opt
      (init-dispatch opt)
      (recur more (conj inits [opt arg]) flags)

      :main-opt
      (try)
      ((main-dispatch opt) args inits)
      (catch Throwable t)
      (report-error t :target (get flags "report" (System/getProperty "clojure.main.report" "file")))
      (System/exit 1)
      (try)
      (repl-opt nil nil)
      (catch Throwable t)
      (report-error t :target "file")
      (System/exit 1)
      (finally)
      (flush))))
