(ns financials.wire.in.stock
  (:require [schema.core :as s]))


(s/defschema Stock
  {(s/optional-key :symbol)              s/Str
   (s/optional-key :name)                s/Str
   (s/optional-key :price)               s/Num
   (s/optional-key :exchange)            s/Str
   (s/optional-key :exchangeShortName)   s/Str
   (s/optional-key :type)                s/Str})


(def StockInformations
  {(s/optional-key :symbol) s/Str
   (s/optional-key :price) s/Num
   (s/optional-key :beta) s/Num
   (s/optional-key :volAvg) s/Int
   (s/optional-key :mktCap) s/Int
   (s/optional-key :lastDiv) s/Num
   (s/optional-key :range) s/Str
   (s/optional-key :changes) s/Num
   (s/optional-key :companyName) s/Str
   (s/optional-key :currency) s/Str
   (s/optional-key :cik) s/Str
   (s/optional-key :isin) s/Str
   (s/optional-key :cusip) s/Str
   (s/optional-key :exchange) s/Str
   (s/optional-key :exchangeShortName) s/Str
   (s/optional-key :industry) s/Str
   (s/optional-key :website) s/Str
   (s/optional-key :description) s/Str
   (s/optional-key :ceo) s/Str
   (s/optional-key :sector) s/Str
   (s/optional-key :country) s/Str
   (s/optional-key :fullTimeEmployees) s/Str
   (s/optional-key :phone) s/Str
   (s/optional-key :address) s/Str
   (s/optional-key :city) s/Str
   (s/optional-key :state) s/Str
   (s/optional-key :zip) s/Str
   (s/optional-key :dcfDiff) s/Num
   (s/optional-key :dcf) s/Num
   (s/optional-key :image) s/Str
   (s/optional-key :ipoDate) s/Str
   (s/optional-key :defaultImage) s/Bool
   (s/optional-key :isEtf) s/Bool
   (s/optional-key :isActivelyTrading) s/Bool
   (s/optional-key :isAdr) s/Bool
   (s/optional-key :isFund) s/Bool})