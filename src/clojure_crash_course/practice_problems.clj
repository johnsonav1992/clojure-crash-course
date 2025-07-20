(ns clojure-crash-course.practice-problems)

;; =============================================================================
;; PRACTICE PROBLEMS - LESSONS 1-3 REVIEW
;; =============================================================================
;; Work through these problems from scratch to reinforce your learning!
;; Try to solve each problem without looking at the lesson files first.

;; =============================================================================
;; LESSON 1 REVIEW: Basic Syntax and Data Types
;; =============================================================================

;; Problem 1: Create different data types
;; TODO: Create variables for each data type and print them
;; - A number (your age)
;; - A string (your favorite food)
;; - A boolean (true if you like programming)
;; - A keyword (like :clojure or :learning)
;; - nil

;; Your solution here:
(def age 33)
(def favorite-food "Thai")
(def likes-programming true)
(:clojure "Clojure")
nil

;; FEEDBACK: Almost perfect! Two small issues:
;; ✅ age, favorite-food, likes-programming - perfect!
;; ❌ (:clojure "Clojure") - this calls :clojure as a function. You want: (def learning-keyword :clojure)
;; ❌ nil - this just evaluates nil. You want: (def nothing nil) 

;; Problem 2: Work with collections
;; TODO: Create the following collections:
;; - A vector of your top 3 favorite colors
;; - A list of numbers from 1 to 5
;; - A map representing a person with :name, :age, and :city keys

;; Your solution here:
(def colors ["red" "orange" "teal"])
(def nums '(1 2 3 4 5))
(def person {:name "Alex" :age 33 :city "Fort Worth"})

;; FEEDBACK: Perfect! ✅ All three collections are exactly right!


;; Problem 3: Access collection elements
;; TODO: Using the collections from Problem 2:
;; - Get the first color from your vector
;; - Get the last number from your list
;; - Get the :name from your person map

;; Your solution here:
(first colors)
(last nums)
(get person :name)

;; FEEDBACK: Perfect! ✅ All three access methods are correct!
;; Note: You could also use (:name person) or (person :name) for map access


;; =============================================================================
;; LESSON 2 REVIEW: Functions
;; =============================================================================

;; Problem 4: Write a simple function
;; TODO: Write a function called `greet` that takes a name and returns
;; "Hello, [name]!" (e.g., "Hello, Alex!")

;; Your solution here:
(defn greet 
 [name]
 (str "Hello, " name "!"))

(greet "Alex")

;; FEEDBACK: Perfect! ✅ Function definition and call are exactly right!


;; Problem 5: Function with multiple parameters
;; TODO: Write a function called `add-three` that takes three numbers
;; and returns their sum

;; Your solution here:
(defn add-three
  [num1 num2 num3]
  (+ num1 num2 num3))

(add-three 1 2 3)

;; FEEDBACK: Perfect! ✅ Great function with multiple parameters!


;; Problem 6: Anonymous function
;; TODO: Create an anonymous function that doubles a number
;; Test it by calling it with the number 7

;; Your solution here:
#(* 2 %)
(#(* 2 %) 7)

;; FEEDBACK: Perfect! ✅ Anonymous function syntax is exactly right!


;; =============================================================================
;; LESSON 3 REVIEW: Collections Operations
;; =============================================================================

;; Problem 7: Transform data with map
;; TODO: Given this vector of numbers: [1 2 3 4 5]
;; Use `map` to create a new vector where each number is multiplied by 10

;; Your solution here:
(def nums [1 2 3 4 5])
(map #(* 10 %) nums)

;; FEEDBACK: Perfect! ✅ Map with anonymous function is exactly right!


;; Problem 8: Filter data
;; TODO: Given this vector of numbers: [1 2 3 4 5 6 7 8 9 10]
;; Use `filter` to create a new vector containing only even numbers

;; Your solution here:
(def filter-nums [1 2 3 4 5 6 7 8 9 10])
(filter even? filter-nums)

;; FEEDBACK: Perfect! ✅ Filter with even? predicate is exactly right!


;; Problem 9: Reduce data
;; TODO: Given this vector of numbers: [10 20 30 40 50]
;; Use `reduce` to find the sum of all numbers

;; Your solution here:
(def nums3 [10 20 30 40 50])
(reduce + nums3)

;; FEEDBACK: Perfect! ✅ Reduce with + function is exactly right!

;; Problem 10: Work with maps
;; TODO: Given this map: {:name "Alice" :age 25 :city "Portland"}
;; - Add a new key :occupation with value "Developer"
;; - Update the :age to 26
;; - Remove the :city key

;; Your solution here:
(def person {:name "Alice" :age 25 :city "Portland"})
(assoc person :occupation "Developer")
(assoc person :age 26)
(dissoc person :city)

;; FEEDBACK: Good start! ✅ You understand assoc and dissoc correctly!
;; ⚠️  However, these operations create separate new maps. To chain them:
;; (-> person 
;;     (assoc :occupation "Developer")
;;     (assoc :age 26)
;;     (dissoc :city))
;; Or: (dissoc (assoc person :occupation "Developer" :age 26) :city)


;; =============================================================================
;; CHALLENGE PROBLEMS
;; =============================================================================

;; Challenge 1: Combine concepts
;; TODO: Write a function that takes a vector of numbers and returns
;; the sum of all even numbers in the vector
;; Hint: You'll need filter, reduce, and maybe an anonymous function

;; Your solution here:
(def nums [1 2 3])
(filter even? nums 
        reduce + )

;; FEEDBACK: Good thinking! ❌ But syntax is wrong - you can't mix functions like that.
;; ✅ Correct solution: (defn sum-evens [numbers] (reduce + (filter even? numbers)))
;; Then call: (sum-evens [1 2 3 4 5 6]) => 12


;; Challenge 2: Working with maps in collections
;; TODO: Given this vector of person maps:
;; [{:name "Alice" :age 25} {:name "Bob" :age 30} {:name "Charlie" :age 20}]
;; Create a new vector containing only the names of people over 21

;; Your solution here:
(def people [{:name "Alice" :age 25} {:name "Bob" :age 30} {:name "Charlie" :age 20}])
(filter #(> 21 % :age) people)

;; FEEDBACK: Good attempt! ❌ The filter syntax is wrong.
;; ✅ Correct solutions:
;; Step 1 - Filter people over 21: (filter #(> (:age %) 21) people)
;; Step 2 - Get just names: (map :name (filter #(> (:age %) 21) people))
;; Combined: (->> people (filter #(> (:age %) 21)) (map :name))


;; =============================================================================
;; PRACTICE ANSWERS (Don't peek until you've tried!)
;; =============================================================================
;; Uncomment these when you want to check your answers:

;; Problem 1 Answer:
;; (def my-age 25)
;; (def favorite-food "pizza")
;; (def likes-programming true)
;; (def learning-keyword :clojure)
;; (def nothing nil)

;; Problem 4 Answer:
;; (defn greet [name]
;;   (str "Hello, " name "!"))

;; Problem 7 Answer:
;; (map #(* % 10) [1 2 3 4 5])
;; ;; => [10 20 30 40 50]

;; Challenge 1 Answer:
;; (defn sum-even-numbers [numbers]
;;   (reduce + (filter even? numbers)))