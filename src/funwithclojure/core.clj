(ns funwithclojure.core)

;;
(defn transform [fn  xs]
  (if (first xs)
    (cons (fn (first xs)) (transform fn (rest xs)))
    (list)
    )
  )