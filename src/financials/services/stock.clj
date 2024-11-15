(ns financials.services.stock
  (:require [clj-http.client :as http.client]))

(defn fetch-stock-data [symbol]
  (let [url "https://finnhub.io/api/v1/quote"
        params {:query-params {"symbol" symbol
                               "token" ""}}
        response (http.client/get url params)]
    (-> response :body)))

(defn fetch-symbols []
  (let [url "https://finnhub.io/api/v1/stock/symbol"
        params {:query-params {"exchange" "BR"
                               "token" ""}}
        response (http.client/get url params)]
    (-> response :body)))