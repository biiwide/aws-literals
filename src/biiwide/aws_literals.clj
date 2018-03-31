(ns biiwide.aws-literals
  (:require [amazonica.aws.simplesystemsmanagement :as ssm]
            [clojure.string :as str]))


(defn comma-separated
  [s]
  (map (fn [s'] (str/replace s' "\\," ","))
       (str/split (str/trim s)
                  #"\s*(?<!\\),\s*")))


(defn ssm-parameter
  [parameter-name]
  
    (let [p (try (:parameter
                   (ssm/get-parameter
                     {:name (name parameter-name)
                      :with-decryption true}))
              (catch Exception e
                (throw (ex-info "Cannot read AWS SSM parameter"
                                {:parameter-name parameter-name}
                                e))))
          value (:value p)]
      (case (:type p)
        "StringList"   (comma-separated value)
        value)))

