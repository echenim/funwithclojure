(ns funwithclojure.recursion.recursion)

;Today 24/10/2018, we will start with a  series fun with clojure
;the goal to using clojure to explore the world of mathematical algorithm
;the goal to getting to know Clojure intimately
;we find out what makes Clojure tick

;my first implementation for factorial
;this implementation for factorial (N1=N x (N-1))
;this implementation is easy but it is deeply flawed
;this implementation with breakdown as N approach 21
;any values greater than 20 with result in ArithmeticException integer overflow  clojure.lang.Numbers.throwIntOverflow
(defn factorial [num]
  (if (<= num 1)
    1 (* num (factorial (dec num)))
    )
  )


;;our goal is to try to improve the previous implementation
;but still plague with the flaw  of previous numbers
(defn factorial2 [num]
  (reduce * (range 1 (inc (long num))))
  )

;this function will return the fatorial fro large numbers and also for small numbers less than 20
; this implementation will work for large numbers
;I got this solution from Carlos D suggestion on stack-over-flow

(defn factorialForlargeNumbers [num]
  ((fn [product counter max-count]
     (if (> counter max-count)
       product
       (recur (apply *' [counter product])
              (inc counter)
              max-count))) 1 1 num)
  )
