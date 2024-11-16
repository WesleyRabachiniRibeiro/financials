(ns financials.services.stock
  (:require [clj-http.client :as http.client]
            [financials.models.stock :as models.stock]
            [financials.adapters.stock :as adapters.stock]
            [cheshire.core :as cheshire]
            [schema.core :as s]))
(def base-url
  "https://financialmodelingprep.com/api/v3")

(s/defn fetch-stock-data :- models.stock/StockInformations
  [symbol :- s/Str]
  (let [url (str base-url "/profile/" symbol)
        params {:query-params {"apikey" ""}}
        response (http.client/get url params {:as :edn})]
    (-> (cheshire/parse-string (:body response) true)
        first
        (adapters.stock/wire-stock-information->model-stock-information))))

(s/defn fetch-stocks :- [models.stock/Stock]
  []
  (let [url (str base-url "/stock/list")
        params {:query-params {"apikey" ""}}
        response (http.client/get url params {:as :edn})
        adapter-map (partial map adapters.stock/wire->model)]
    (->> (cheshire/parse-string (:body response) true)
         adapter-map
         (remove nil?))))