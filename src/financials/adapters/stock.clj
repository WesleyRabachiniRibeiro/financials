(ns financials.adapters.stock
  (:require
    [financials.models.stock :as models.stock]
    [schema.core :as s]
    [financials.wire.in.stock :as wire.in.stock]
    [financials.wire.out.stock :as wire.out.stock]
    [financials.helpers :as helpers]))

(s/defn wire->model :- models.stock/Stock
  [{:keys [symbol name price exchange exchangeShortName]}] :- wire.in.stock/Stock
  (->> #:stock{:symbol              symbol
               :name                name
               :price               price
               :exchange            exchange
               :exchange-short-name exchangeShortName}
       (helpers/remove-vals nil?)))

(s/defn model->wire :- wire.out.stock/Stock
  [{:stock/keys [symbol name price exchange exchange-short-name]}] :- models.stock/Stock
  (->> {:symbol              symbol
        :name                name
        :price               price
        :exchange            exchange
        :exchange-short-name exchange-short-name}
       (helpers/remove-vals nil?)))

(s/defn wire-stock-information->model-stock-information :- models.stock/StockInformations
  [{:keys [symbol price beta volAvg mktCap lastDiv range changes companyName currency cik isin cusip exchange
           exchangeShortName industry website description ceo sector country fullTimeEmployees phone address
           city state zip dcfDiff dcf image ipoDate defaultImage isEtf isActivelyTrading isAdr isFund]}] :- wire.in.stock/StockInformations
  (->> #:stock{:symbol              symbol
               :price               price
               :beta                beta
               :vol-avg             volAvg
               :mkt-cap             mktCap
               :last-div            lastDiv
               :range               range
               :changes             changes
               :company-name        companyName
               :currency            currency
               :cik                 cik
               :isin                isin
               :cusip               cusip
               :exchange            exchange
               :exchange-short-name exchangeShortName
               :industry            industry
               :website             website
               :description         description
               :ceo                 ceo
               :sector              sector
               :country             country
               :full-time-employees fullTimeEmployees
               :phone               phone
               :address             address
               :city                city
               :state               state
               :zip                 zip
               :dcf-diff            dcfDiff
               :dcf                 dcf
               :image               image
               :ipo-date            ipoDate
               :default-image       defaultImage
               :is-etf              isEtf
               :is-actively-trading isActivelyTrading
               :is-adr              isAdr
               :is-fund             isFund}
       (helpers/remove-vals nil?)))

(s/defn model-stock-information->wire-stock-information :- wire.out.stock/StockInformations
  [{:stock/keys [symbol price beta vol-avg mkt-cap last-div range changes company-name currency cik isin cusip exchange
                 exchange-short-name industry website description ceo sector country full-time-employees phone address city
                 state zip dcf-diff dcf image ipo-date default-image is-etf is-actively-trading is-adr is-fund]}] :- models.stock/StockInformations
  (->> {:symbol              symbol
        :price               price
        :beta                beta
        :vol-avg             vol-avg
        :mkt-cap             mkt-cap
        :last-div            last-div
        :range               range
        :changes             changes
        :company-name        company-name
        :currency            currency
        :cik                 cik
        :isin                isin
        :cusip               cusip
        :exchange            exchange
        :exchange-short-name exchange-short-name
        :industry            industry
        :website             website
        :description         description
        :ceo                 ceo
        :sector              sector
        :country             country
        :full-time-employees full-time-employees
        :phone               phone
        :address             address
        :city                city
        :state               state
        :zip                 zip
        :dcf-diff            dcf-diff
        :dcf                 dcf
        :image               image
        :ipo-date            ipo-date
        :default-image       default-image
        :is-etf              is-etf
        :is-actively-trading is-actively-trading
        :is-adr              is-adr
        :is-fund             is-fund}
       (helpers/remove-vals nil?)))

