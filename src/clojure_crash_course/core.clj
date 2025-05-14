(ns clojure-crash-course.core
  (:require [clojure-crash-course.utils :as utils]))

(defn -main
  []
  (println "Hello!")
  (def something (utils/add 1 2))
  (println something))