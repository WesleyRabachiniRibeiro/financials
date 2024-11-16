(ns financials.models.stock
  (:require [schema.core :as s]))

(s/defschema Stock
  #:stock{(s/optional-key :symbol)              s/Str
          (s/optional-key :name)                s/Str
          (s/optional-key :price)               s/Num
          (s/optional-key :exchange)            s/Str
          (s/optional-key :exchange-short-name) s/Str})

(def StockInformations
  #:stock{(s/optional-key :symbol)              s/Str
          (s/optional-key :price)               s/Num
          (s/optional-key :beta)                s/Num
          (s/optional-key :vol-avg)             s/Int
          (s/optional-key :mkt-cap)             s/Int
          (s/optional-key :last-div)            s/Num
          (s/optional-key :range)               s/Str
          (s/optional-key :changes)             s/Num
          (s/optional-key :company-name)        s/Str
          (s/optional-key :currency)            s/Str
          (s/optional-key :cik)                 s/Str
          (s/optional-key :isin)                s/Str
          (s/optional-key :cusip)               s/Str
          (s/optional-key :exchange)            s/Str
          (s/optional-key :exchange-short-name) s/Str
          (s/optional-key :industry)            s/Str
          (s/optional-key :website)             s/Str
          (s/optional-key :description)         s/Str
          (s/optional-key :ceo)                 s/Str
          (s/optional-key :sector)              s/Str
          (s/optional-key :country)             s/Str
          (s/optional-key :full-time-employees) s/Str
          (s/optional-key :phone)               s/Str
          (s/optional-key :address)             s/Str
          (s/optional-key :city)                s/Str
          (s/optional-key :state)               s/Str
          (s/optional-key :zip)                 s/Str
          (s/optional-key :dcf-diff)            s/Num
          (s/optional-key :dcf)                 s/Num
          (s/optional-key :image)               s/Str
          (s/optional-key :ipo-date)            s/Str
          (s/optional-key :default-image)       s/Bool
          (s/optional-key :is-etf)              s/Bool
          (s/optional-key :is-actively-trading) s/Bool
          (s/optional-key :is-adr)              s/Bool
          (s/optional-key :is-fund)             s/Bool})