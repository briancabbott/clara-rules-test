(ns clara-rules-test.parent-rules-single-ns.rule-single
  (:require [clara.rules :refer :all]))


(defrecord MyFirstRecordOne [rule-name num] )
(defrecord MyFirstRecordTwo [rule-name num] )


(defrule is-important
  "Find important support requests."
  [MyFirstRecordOne (> num 5)]
  [MyFirstRecordTwo (> num 15)]
  =>
  (println "Rules are over 5 and 15!"))
