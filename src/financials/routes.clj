(ns financials.routes
  (:require
    [financials.adapters.stock :as adapters.stock]
    [financials.wire.out.stock :as wire.out.stock]
    [io.pedestal.http.route :as route]
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
        response (-> (controllers.stock/get-by-stock! symbol)
                     (adapters.stock/model-stock-information->wire-stock-information))]
    (if response
      {:status 200
       :body response}
      {:status 404
       :body {:error "Stock not found"}})))

(defn get-stocks!
  [_]
  (let [response (->> (controllers.stock/get-stocks)
                      (map adapters.stock/model->wire))]
    (if response
      {:status 200
       :body response}
      {:status 404
       :body {:error "Stocks not found"}})))

(defn get-symbols!
  [_]
  (let [response (controllers.stock/fetch-symbols)]
    {:status 200
     :body response}))

(def default-routes
  #{["/api/version"
     :get current-version
     :route-name :version]})

(def stocks
  #{["/api/stock"
     :get (conj [(interceptors.adapt/query-coerce {:symbol s/Str})
                 (interceptors.adapt/externalize {200 wire.out.stock/StockInformations})
                 interceptors.adapt/content-type-edn]
                get-by-stock!)
     :route-name :get-by-stock]

    ["/api/stock/list"
     :get (conj [(interceptors.adapt/externalize {200 [wire.out.stock/Stock]})
                 interceptors.adapt/content-type-edn]
                get-stocks!)
     :route-name :get-stock-list]

    ["/api/symbols"
     :get (conj [(interceptors.adapt/externalize {200 [s/Str]})
                 interceptors.adapt/content-type-edn]
                get-symbols!)
     :route-name :get-symbols]})

(def routes
  (route/expand-routes
    (clojure.set/union default-routes
                       stocks)))


