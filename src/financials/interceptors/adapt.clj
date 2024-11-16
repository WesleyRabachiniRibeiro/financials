(ns financials.interceptors.adapt
  (:require [clojure.data.json :as json]
            [io.pedestal.interceptor :as i]
            [schema.core :as s]))


(defn externalize [schema]
  (i/interceptor
    {:name  ::externalize
     :leave (fn [context]
              (let [response (:response context)
                    status (:status response)
                    schema (get schema status)]
                (if (and schema (s/validate schema (:body response)))
                  context
                  (assoc context :response {:status 500
                                            :body   "Invalid Response Schema"}))))}))


(defn coerce [schema]
  (i/interceptor
    {:name  ::coerce
     :enter (fn [context]
              (let [request (:request context)
                    body (:body request)]
                (if (s/validate schema body)
                  context
                  (assoc context :response {:status 400
                                            :body   "Invalid Request Schema"}))))}))

(defn query-coerce [schema]
  (i/interceptor
    {:name  ::query-coerce
     :enter (fn [context]
              (let [request (:request context)
                    query-params (:query-params request)]
                (if (s/validate schema query-params)
                  context
                  (assoc context :response {:status 400
                                            :body   "Invalid Query Params"}))))}))

(def content-type-edn
  (i/interceptor
    {:name  :edn
     :leave (fn [context]
              (let [response (:response context)]
                (->> (assoc response :headers {"Content-Type" "application/edn"})
                     (assoc context :response))))}))