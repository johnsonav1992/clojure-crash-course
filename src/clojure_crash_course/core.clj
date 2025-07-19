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

(defn -main
  []
  (println "Hello!")
  (def something (utils/add 1 2))
  (println something))