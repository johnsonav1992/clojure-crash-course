(ns clojure-crash-course.lesson4-control-flow)

;; LESSON 4: Control Flow and Conditionals

;; IF - the basic conditional
(if true "yes" "no")
(if false "yes" "no")

;; IF with variables
(def age 25)
(if (> age 18) "adult" "minor")

;; IF without an else part
(if (> age 65) "senior citizen")

;; WHEN - like if but for multiple statements
(when (> age 18)
  (println "You can vote!")
  (println "You can drive!")
  "adult")

;; COND - multiple conditions (like switch/case)
(defn describe-age [age]
  (cond
    (< age 13) "child"
    (< age 20) "teenager"  
    (< age 65) "adult"
    :else "senior"))

(describe-age 10)
(describe-age 16)
(describe-age 30)
(describe-age 70)

;; CASE - exact matching
(defn day-type [day]
  (case day
    :monday "start of work week"
    :friday "almost weekend!"
    :saturday "weekend!"
    :sunday "weekend!"
    "regular day"))

(day-type :monday)
(day-type :friday)
(day-type :wednesday)

;; Combining with collections
(def numbers [1 2 3 4 5 6 7 8 9 10])

;; Find all even numbers greater than 5
(filter #(and (even? %) (> % 5)) numbers)

;; Transform based on condition
(map #(if (even? %) (* % 2) %) numbers)

;; Boolean logic
(and true true)      ; Both must be true
(and true false)     ; Both must be true
(or true false)      ; One must be true
(or false false)     ; One must be true
(not true)           ; Opposite
(not false)          ; Opposite