(ns biiwide.aws-literals-test
  (:require [clojure.test :refer :all]
            [biiwide.aws-literals :refer :all]))


(deftest test-comma-separated
  (are [expected value]
       (= expected (comma-separated value))

       ["abc"]
       "  abc\n"

       ["foo" "bar" "fizz,buzz"]
       "foo,bar, fizz\\,buzz"
       
       ["one" "two"]
       "one\n,two"
       ))

