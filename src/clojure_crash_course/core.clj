(ns clojure-crash-course.core
  (:require [clojure-crash-course.utils :as utils]))

(defn -main
  []
  (println "Hello!")
  (println (utils/add 1 2)))