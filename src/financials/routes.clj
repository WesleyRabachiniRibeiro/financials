(ns financials.routes
  (:require [io.pedestal.http.route :as route]
            [financials.interceptors.adapt :as interceptors.adapt]
            [financials.controllers.stock :as controllers.stock]
            [schema.core :as s]))

(defn current-version
  [_]
  {:status 200
   :body {:version "^1.0.0"}})

(defn get-by-stock!
  [request]
  (let [symbol (get-in request [:query-params :symbol])
        response (controllers.stock/get-by-stock! symbol)]
    (if response
      {:status 200
       :body response}
      {:status 404
       :body {:error "Stock not found"}})))

(defn get-symbols!
  [_]
  (let [response (controllers.stock/get-symbols)]
    (if response
      {:status 200
       :body response}
      {:status 404
       :body {:error "Symbols not found"}})))

(def default-routes
  #{["/api/version"
     :get current-version
     :route-name :version]})

(def stocks
  #{["/api/stock"
     :get (conj [(interceptors.adapt/externalize {200 s/Any})
                 interceptors.adapt/content-type-json]
                get-by-stock!)
     :route-name :get-by-stock]
    ["/api/symbols"
     :get (conj [(interceptors.adapt/externalize {200 s/Any})
                 interceptors.adapt/content-type-json]
                get-symbols!)
     :route-name :get-symbols]})

(def routes
  (route/expand-routes
    (clojure.set/union default-routes
                       stocks)))


