(defproject financials "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [io.pedestal/pedestal.service "0.5.8"]
                 [io.pedestal/pedestal.route "0.5.8"]
                 [io.pedestal/pedestal.jetty "0.5.8"]
                 [clj-http "3.12.3"]
                 [cheshire "5.10.0"]
                 [org.clojure/data.json "2.5.0"]
                 [org.slf4j/slf4j-simple "1.7.32"]
                 [prismatic/schema       "1.1.12"]]
  :repl-options {:init-ns financials.server}
  :main ^{:skip-aot false} financials.server)
