(ns financials.server
  (:require [financials.routes :as routes]
            [io.pedestal.http :as http]))

(defn -init [start-fn & _args] (start-fn {:mode :embedded}))

(def service-map (-> {::http/routes routes/routes
                      ::http/type   :jetty
                      ::http/port   9000}))

(def create-and-start-system! (http/start (http/create-server service-map)))

(def -main (partial -init create-and-start-system!))

