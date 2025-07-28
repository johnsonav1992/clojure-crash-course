(ns clojure-crash-course.lesson5-let-bindings)

;; ============================================================================
;; LESSON 5: LET BINDINGS AND LOCAL VARIABLES
;; ============================================================================

;; Let bindings allow you to create local variables within a specific scope
;; This helps make code more readable and avoid repeating calculations

;; Basic let syntax:
;; (let [binding-vector]
;;   body)

;; ============================================================================
;; 1. BASIC LET BINDINGS
;; ============================================================================

;; Simple example - creating local variables
(defn calculate-circle-area [radius]
  (let [pi 3.14159
        radius-squared (* radius radius)]
    (* pi radius-squared)))

;; Test it:
(calculate-circle-area 5)  ; => 78.53975

;; Without let, this would be messy:
(defn calculate-circle-area-messy [radius]
  (* 3.14159 (* radius radius)))

;; ============================================================================
;; 2. MULTIPLE BINDINGS
;; ============================================================================

;; You can create multiple local variables in one let
(defn format-person [first-name last-name age]
  (let [full-name (str first-name " " last-name)
        age-description (if (>= age 18) "adult" "minor")
        greeting (str "Hello, " full-name)]
    (str greeting ". You are an " age-description ".")))

;; Test it:
(format-person "John" "Doe" 25)  ; => "Hello, John Doe. You are an adult."

;; ============================================================================
;; 3. BINDINGS CAN REFERENCE PREVIOUS BINDINGS
;; ============================================================================

;; Later bindings can use earlier ones in the same let
(defn compound-interest [principal rate years]
  (let [rate-decimal (/ rate 100.0)
        rate-plus-one (+ 1 rate-decimal)
        power (Math/pow rate-plus-one years)]
    (* principal power)))

;; Test it:
(compound-interest 1000 5 10)  ; => 1628.8946267774416

;; ============================================================================
;; 4. NESTED LET BINDINGS
;; ============================================================================

;; You can nest let bindings when you need different scopes
(defn process-order [items tax-rate discount]
  (let [subtotal (reduce + items)
        discounted-total (* subtotal (- 1 discount))]
    (let [tax-amount (* discounted-total tax-rate)
          final-total (+ discounted-total tax-amount)]
      {:subtotal subtotal
       :discount-amount (* subtotal discount)
       :tax-amount tax-amount
       :final-total final-total})))

;; Test it:
(process-order [10.99 25.50 8.75] 0.08 0.1)

;; ============================================================================
;; 5. DESTRUCTURING WITH LET
;; ============================================================================

;; You can destructure collections directly in let bindings

;; Destructuring vectors:
(defn analyze-coordinates [point]
  (let [[x y] point
        distance-from-origin (Math/sqrt (+ (* x x) (* y y)))]
    {:x x
     :y y
     :distance distance-from-origin}))

;; Test it:
(analyze-coordinates [3 4])  ; => {:x 3, :y 4, :distance 5.0}

;; Destructuring maps:
(defn format-user-info [user]
  (let [{:keys [name age email]} user
        domain (last (clojure.string/split email #"@"))]
    (str name " (" age " years old) uses " domain " email")))

;; Test it:
(format-user-info {:name "Alice" :age 30 :email "alice@gmail.com"})
;; => "Alice (30 years old) uses gmail.com email"

;; ============================================================================
;; 6. PRACTICAL EXAMPLES
;; ============================================================================

;; Example: Processing student grades
(defn calculate-grade [scores]
  (let [total (reduce + scores)
        count (count scores)
        average (/ total count)
        letter-grade (cond
                       (>= average 90) "A"
                       (>= average 80) "B"
                       (>= average 70) "C"
                       (>= average 60) "D"
                       :else "F")]
    {:scores scores
     :total total
     :average average
     :letter-grade letter-grade}))

;; Test it:
(calculate-grade [85 92 78 88 91])

;; Example: String processing
(defn clean-and-analyze-text [text]
  (let [cleaned (clojure.string/trim (clojure.string/lower-case text))
        words (clojure.string/split cleaned #"\s+")
        word-count (count words)
        char-count (count cleaned)
        avg-word-length (if (> word-count 0)
                          (/ char-count word-count)
                          0)]
    {:original text
     :cleaned cleaned
     :word-count word-count
     :char-count char-count
     :avg-word-length avg-word-length}))

;; Test it:
(clean-and-analyze-text "  Hello WORLD! This is a TEST.  ")

;; ============================================================================
;; 7. WHEN TO USE LET VS FUNCTION PARAMETERS
;; ============================================================================

;; Use let when:
;; - You need to calculate intermediate values
;; - You want to make code more readable
;; - You need to destructure complex data

;; Compare these two approaches:

;; Without let (harder to read):
(defn pythagorean-without-let [a b]
  (Math/sqrt (+ (* a a) (* b b))))

;; With let (clearer intent):
(defn pythagorean-with-let [a b]
  (let [a-squared (* a a)
        b-squared (* b b)
        sum (+ a-squared b-squared)]
    (Math/sqrt sum)))

;; ============================================================================
;; PRACTICE EXERCISES
;; ============================================================================

;; Exercise 1: Temperature Converter
;; Write a function that converts Celsius to Fahrenheit and Kelvin
;; Use let to store intermediate calculations
;; Formula: F = (C * 9/5) + 32, K = C + 273.15

(defn temperature-converter [celsius]
  ;; YOUR CODE HERE
  ;; Should return a map with :celsius, :fahrenheit, and :kelvin
  (let [fahrenheit (+ (* celsius 9/5) 32)
        kelvin (+ celsius 273.15)]
    {:celsius celsius
     :fahrenheit fahrenheit
     :kelvin kelvin}))

(temperature-converter 30)

;; Exercise 2: Shopping Cart Calculator
;; Write a function that takes a vector of item maps like:
;; [{:name "Apple" :price 1.50 :quantity 3}
;;  {:name "Bread" :price 2.99 :quantity 1}]
;; Calculate total cost, apply tax, and return detailed breakdown

(defn calculate-cart [items tax-rate]
  ;; YOUR CODE HERE
  ;; Use let to calculate subtotal, tax, and total
  ;; Return map with :items, :subtotal, :tax, :total
  (let [subtotal (reduce + (map #(* (:price %) (:quantity %)) items))
        tax (Math/round (* subtotal tax-rate))
        total (+ subtotal tax)]
    {:items items
     :subtotal subtotal
     :tax tax
     :total total}))
(calculate-cart [{:name "Apple" :price 1.50 :quantity 3}
                  {:name "Bread" :price 2.99 :quantity 1}] 0.08)

;; Exercise 3: String Statistics
;; Write a function that analyzes a sentence and returns:
;; - Number of words
;; - Number of vowels
;; - Number of consonants
;; - Longest word
;; Use let with destructuring and intermediate calculations

(defn analyze-sentence [sentence]
  ;; YOUR CODE HERE
  ;; Use let to break down the analysis steps
  (let [words (clojure.string/split sentence #"\s+")
        word-count (count words)
        vowels (count (filter #(re-matches #"[aeiouAEIOU]" %) (apply str words)))
        consonants (count (filter #(re-matches #"[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]" %) (apply str words)))
        longest-word (apply max-key count words)]
    {:word-count word-count
     :vowels vowels
     :consonants consonants
     :longest-word longest-word}))

(analyze-sentence "The quick brown fox jumps over the lazy dog.")


;; Exercise 4: Date Formatter
;; Write a function that takes a date string "2024-01-15" and formats it
;; as "January 15, 2024". Use let with destructuring.

(defn format-date [date-string]
  ;; YOUR CODE HERE
  ;; Use let to destructure the date parts
  ;; Map month numbers to names
  (let [month-names {1 "January" 2 "February" 3 "March"
                     4 "April" 5 "May" 6 "June"
                     7 "July" 8 "August" 9 "September"
                     10 "October" 11 "November" 12 "December"}
        [year month day] (map parse-long (clojure.string/split date-string #"-"))]
    (str (month-names month) " " day ", " year)))

(format-date "2024-01-15")  ; => "January 15, 2024"

;; ============================================================================
;; SOLUTIONS (Don't peek until you try!)
;; ============================================================================

;; Uncomment to see solutions:

;; (defn temperature-converter-solution [celsius]
;;   (let [fahrenheit (+ (* celsius 9/5) 32)
;;         kelvin (+ celsius 273.15)]
;;     {:celsius celsius
;;      :fahrenheit fahrenheit
;;      :kelvin kelvin}))

;; (defn calculate-cart-solution [items tax-rate]
;;   (let [subtotal (reduce + (map #(* (:price %) (:quantity %)) items))
;;         tax (* subtotal tax-rate)
;;         total (+ subtotal tax)]
;;     {:items items
;;      :subtotal subtotal
;;      :tax tax
;;      :total total}))