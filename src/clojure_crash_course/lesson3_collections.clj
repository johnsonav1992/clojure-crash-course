(ns clojure-crash-course.lesson3-collections)

;; LESSON 3: Working with Collections
;; This is where Clojure really shines!

;; Sample data to work with
(def fruits ["apple" "banana" "cherry" "date"])
(def numbers [1 2 3 4 5])
(def person {:name "Alex" :age 25 :city "New York"})

;; MAP - transform every item in a collection
(map inc numbers)                    ; Add 1 to each number
(map clojure.string/upper-case fruits)  ; Make each fruit UPPERCASE

;; FILTER - keep only items that match a condition
(filter even? numbers)               ; Keep only even numbers
(filter #(> (count %) 5) fruits)     ; Keep only fruits with more than 5 letters

;; REDUCE - combine all items into a single value
(reduce + numbers)                   ; Add all numbers together
(reduce str fruits)                  ; Combine all fruits into one string

;; COUNT - how many items?
(count fruits)
(count numbers)

;; FIRST and LAST
(first fruits)
(last fruits)

;; REST - everything except the first
(rest fruits)

;; TAKE and DROP
(take 2 fruits)                      ; Take first 2 items
(drop 2 fruits)                      ; Drop first 2 items, keep the rest

;; Working with maps
(keys person)                        ; Get all keys
(vals person)                        ; Get all values
(assoc person :job "Programmer")     ; Add a new key-value pair
(dissoc person :age)                 ; Remove a key-value pair

;; Combining functions - this is the magic!
(map inc (filter even? numbers))     ; Get even numbers, then add 1 to each
(->> numbers                         ; "Thread-last" macro for readability
     (filter even?)
     (map inc))