(ns clojure-crash-course.core
  (:require [clojure-crash-course.utils :as utils]))

;; LESSON 1: Basic Syntax and Data Types
;; Put cursor after each expression and press Cmd+Enter to evaluate

;; Basic arithmetic - operator comes FIRST
(+ 1 2)
(- 10 3)
(* 4 5)
(/ 12 3)

;; Nested expressions work inside-out
(+ (* 2 3) 4)

;; Basic data types
42
"Hello World"
true
false
nil

;; Strings can be manipulated
(str "Hello" " " "World")

;; Variables (they're actually immutable!)
(def my-name "Alex")
(def my-age 25)
(def result (+ 10 5))

;; Use variables
my-name
(str "Hello " my-name)
(+ my-age 5)

;; Collections - the heart of Clojure!
;; Lists (with parentheses)
'(1 2 3 4)
'("apple" "banana" "cherry")

;; Vectors (with square brackets)
[1 2 3 4]
["apple" "banana" "cherry"]

;; Maps (like dictionaries - with curly braces)
{:name "Alex" :age 25 :city "New York"}

;; Keywords start with :
:name
:age
:favorite-color

;; Getting data OUT of collections
;; From vectors - use nth (0-based indexing)
(nth [10 20 30 40] 0)    ; Gets first item (10)
(nth [10 20 30 40] 2)    ; Gets third item (30)

;; From maps - use keywords or get
(get {:name "Alex" :age 25} :name)    ; Gets "Alex"
(get {:name "Alex" :age 25} :age)     ; Gets 25
(:name {:name "Alex" :age 25})        ; Same thing! Keywords work as functions

;; Lists vs Vectors - the difference:
;; Lists are for CODE (functions), Vectors are for DATA
;; When you DON'T quote a list, Clojure tries to RUN it as a function:
;; (+ 1 2)     ; This RUNS the + function
;; '(+ 1 2)    ; This is just DATA - the list containing +, 1, and 2

(defn -main
  []
  (println "Hello!")
  (def something (utils/add 1 2))
  (println something))