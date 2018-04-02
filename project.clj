(defproject biiwide/aws-literals "0.0.1-SNAPSHOT"

  :description "Tagged literals for AWS"

  :url "https://github.com/biiwide/aws-literals"

  :license {:name "Eclipse Public License 2.0"
            :url "https://www.eclipse.org/legal/epl-2.0"}

  :deploy-repositories {"releases" {:url "https://repo.clojars.org" :creds :gpg}}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [amazonica "0.3.121"
                  :exclusions [com.amazonaws/amazon-kinesis-client
                               com.amazonaws/aws-java-sdk
                               com.amazonaws/dynamodb-streams-kinesis-adapter
                               com.taoensso/nippy]]
                 [com.amazonaws/aws-java-sdk-s3 "1.11.282"]
                 [com.amazonaws/aws-java-sdk-sts "1.11.282"]
                 [com.amazonaws/aws-java-sdk-ssm "1.11.282"]
                 ]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  )
