(ns clojure-crash-course.lesson2-functions)

;; LESSON 2: Functions
;; Put cursor after each expression and press Cmd+Enter to evaluate

;; Simple function - no parameters
(defn say-hello
  []
  "Hello from my function!")

;; Call it
(say-hello)

;; Function with one parameter
(defn greet
  [name]
  (str "Hello " name "!"))

;; Call it
(greet "Alex")
(greet "World")
(greet "Bob")

;; Function with multiple parameters
(defn add-three
  [x y z]
  (+ x y z))

;; Call it
(add-three 1 2 3)
(add-three 10 20 30)

;; Function that uses other functions
(defn greet-loudly
  [name]
  (str "HELLO " (clojure.string/upper-case name) "!!!"))

(greet-loudly "alex")

;; Anonymous functions (functions without names)
(fn [x] (* x 2))

;; Use anonymous function immediately
((fn [x] (* x 2)) 5)

;; Shorthand for anonymous functions
#(* % 2)

;; Use shorthand
(#(* % 2) 5)