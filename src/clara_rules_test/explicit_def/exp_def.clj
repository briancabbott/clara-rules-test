(ns clara-rules-test.explicit-def.exp-def
  ; (:require [clara-rules-test.parent-rules-split-ns.rule-records :refer :all])
  (:import [clara_rules_test.parent_rules_split_ns.rule_records MyFirstRecordOne MyFirstRecordTwo]))


(def explicit
  ; (defrecord MyFirstRecordOne [rule-name num])
  ; (defrecord MyFirstRecordTwo [rule-name num])
  [{:doc  "Find important support requests."
    :name "clara-rules-test.explicit-def.exp-def/is-important"
    :lhs  [{:type        'clara_rules_test.parent_rules_split_ns.rule_records.MyFirstRecordOne
            :constraints '[(> num 5)]}
           {:type        'clara_rules_test.parent_rules_split_ns.rule_records.MyFirstRecordTwo
            :constraints '[(> num 15)]}]
    :rhs  '(println "Rules are over 5 and 15!")}])
