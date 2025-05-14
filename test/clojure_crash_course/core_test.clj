(ns clojure-crash-course.core-test
  (:require [clojure.test :refer :all]
            [clojure-crash-course.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest foo-test
  (testing "foo function"
    (is (= (with-out-str (foo)) "Hello, World!\n"))))
