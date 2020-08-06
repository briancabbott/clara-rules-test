(ns clara-rules-test.core
  (:require
    [clojure.pprint :as pp]
    [clara.rules :refer :all]
    [clara.tools.inspect :refer :all]
    [clara.tools.tracing :refer :all]

    ; [clara-rules-test.parent-rules-single-ns.rule-single :refer :all]

    ; [clara-rules-test.parent-rules-split-ns.rules :refer :all]
    [clara-rules-test.parent-rules-split-ns.rule-records :refer :all]
    [clara-rules-test.explicit-def.exp-def :refer :all])
  (:import [clara_rules_test.parent_rules_split_ns.rule_records MyFirstRecordOne MyFirstRecordTwo])
  (:gen-class))


; (defn single-rules-runner []
;   (-> (mk-session 'clara-rules-test.parent-rules-single-ns.rule-single)
;     (insert (->MyFirstRecordOne "fist rule" 30)
;             (->MyFirstRecordTwo "second" 345))
;     (fire-rules)))

; (defn split-rules-runner []
;   (prn "split-rules-runner")
;   (defsession rule-session-def 'clara-rules-test.parent-rules-split-ns.rule-records 'clara-rules-test.parent-rules-split-ns.rules)
;   (prn "  defsession complete")
;
;   (let [rule-session (-> rule-session-def
;                          (with-tracing)
;                          (insert (->MyFirstRecordOne "fist rule" 30)
;                                  (->MyFirstRecordTwo "second" 345))
;                          (fire-rules))
;         inspect (inspect rule-session)
;         trace (get-trace rule-session)]
;
;     (prn "  let binding complete")
;     (pp/pprint inspect)
;     (pp/pprint trace)
;
;     (explain-activations rule-session)))

(defn explicit-rules-runner []
  (defsession rule-session-def 'clara-rules-test.explicit-def.exp-def/explicit 'clara-rules-test.parent-rules-split-ns.rule-records)
  (let [rule-session (-> rule-session-def
                           (with-tracing)
                           (insert (->MyFirstRecordOne "fist rule" 30)
                                   (->MyFirstRecordTwo "second" 345))
                           (fire-rules))
          inspect (inspect rule-session)
          trace (get-trace rule-session)]

      (prn "  let binding complete")
      (pp/pprint inspect)
      (pp/pprint trace)

      (explain-activations rule-session)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ; (single-rules-runner)
  ; (split-rules-runner)
  (explicit-rules-runner)
  )
