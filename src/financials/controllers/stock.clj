(ns financials.controllers.stock
  (:require [financials.services.stock :as services.stock]))

(defn get-symbols
  []
  (services.stock/fetch-symbols))

(defn get-by-stock!
  [symbol]
  (services.stock/fetch-stock-data symbol))