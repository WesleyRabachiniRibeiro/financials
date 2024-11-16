(ns financials.controllers.stock
  (:require [financials.services.stock :as services.stock]
            [financials.models.stock :as models.stock]
            [schema.core :as s]))

(s/defn get-stocks :- [models.stock/Stock]
  []
  (services.stock/fetch-stocks))

(s/defn get-by-stock! :- models.stock/StockInformations
  [symbol :- s/Str]
  (services.stock/fetch-stock-data symbol))