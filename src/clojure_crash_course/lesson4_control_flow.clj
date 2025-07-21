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

;; ======================
;; PRACTICE EXERCISES
;; ======================

;; Exercise 1: Write a function that determines if a number is positive, negative, or zero
;; TODO: Write function called 'number-sign' that takes a number and returns:
;; - "positive" if > 0
;; - "negative" if < 0  
;; - "zero" if = 0
(defn number-sign
  [a]
  (cond
    (> a 0) "positive"
    (< a 0) "negative"
    :else "zero"))

(number-sign 4)
(number-sign -1)
(number-sign 0)

;; Exercise 2: Grade calculator
;; TODO: Write function called 'letter-grade' that takes a score (0-100) and returns:
;; - "A" for 90-100
;; - "B" for 80-89
;; - "C" for 70-79
;; - "D" for 60-69
;; - "F" for below 60

(defn letter-grade
  [score]
  (cond
    (and (>= score 90) (<= score 100)) "A"
    (and (>= score 80) (< score 90)) "B"
    (and (>= score 70) (< score 80)) "C"
    (and (>= score 60) (< score 70)) "D"
    (< score 60) "F"))

(letter-grade 55)
(letter-grade 60)
(letter-grade 75)
(letter-grade 85)
(letter-grade 80)
(letter-grade 90)

;; Exercise 3: Traffic light logic
;; TODO: Write function called 'traffic-action' that takes a color keyword and returns:
;; - :red -> "stop"
;; - :yellow -> "caution" 
;; - :green -> "go"
;; - anything else -> "broken light"

(defn traffic-action
  [color]
  (case color
    :red "stop"
    :yellow "caution"
    :green "go"
    "broken light"))

(traffic-action :red)
(traffic-action :yellow)
(traffic-action :green)
(traffic-action :blue)

;; Exercise 4: Weekend checker
;; TODO: Write function called 'is-weekend?' that takes a day keyword and returns true/false
;; Weekend days are :saturday and :sunday

(defn is-weekend?
  [day]
  (or (= day :saturday) (= day :sunday)))

(is-weekend? :monday)
(is-weekend? :saturday)
(is-weekend? :sunday)

;; Exercise 5: Temperature classifier
;; TODO: Write function called 'temp-category' that takes temperature in F and returns:
;; - "freezing" if <= 32
;; - "cold" if 33-50
;; - "mild" if 51-70
;; - "warm" if 71-85
;; - "hot" if > 85

(defn temp-category
  [temp]
  (cond
    (<= temp 32) "freezing"
    (<= temp 50) "cold"
    (<= temp 70) "mild"
    (<= temp 85) "warm"
    :else "hot"))

(temp-category 20)
(temp-category 40)
(temp-category 60)
(temp-category 80)
(temp-category 90)