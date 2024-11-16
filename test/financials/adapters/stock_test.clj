(ns financials.adapters.stock-test
  (:require [clojure.test :refer :all]
            [financials.adapters.stock :as adapters.stock]))

(def wire-in
  {:symbol            "EOX.TO",
   :name              "Euromax Resources Ltd.",
   :price             0.02,
   :exchange          "Toronto Stock Exchange",
   :exchangeShortName "TSX",
   :type              "stock"})

(def model
  #:stock{:symbol              "EOX.TO"
          :name                "Euromax Resources Ltd."
          :price               0.02
          :exchange            "Toronto Stock Exchange"
          :exchange-short-name "TSX"})

(def wire-out
  {:symbol              "EOX.TO"
   :name                "Euromax Resources Ltd."
   :price               0.02
   :exchange            "Toronto Stock Exchange"
   :exchange-short-name "TSX"})

(def wire-in-stock-informations
  {:symbol              "AAPL"
   :price               178.72
   :beta                1.286802
   :volAvg              58405568
   :mktCap              2794144143933
   :lastDiv             0.96
   :range               "124.17-198.23"
   :changes             -0.13
   :companyName        "Apple Inc."
   :currency            "USD"
   :cik                 "0000320193"
   :isin                "US0378331005"
   :cusip               "037833100"
   :exchange            "NASDAQ Global Select"
   :exchangeShortName   "NASDAQ"
   :industry            "Consumer Electronics"
   :website             "https://www.apple.com"
   :description         "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. It also sells various related services. In addition, the company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; AirPods Max, an over-ear wireless headphone; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, HomePod, and iPod touch. Further, it provides AppleCare support services; cloud services store services; and operates various platforms, including the App Store that allow customers to discover and download applications and digital content, such as books, music, video, games, and podcasts. Additionally, the company offers various services, such as Apple Arcade, a game subscription service; Apple Music, which offers users a curated listening experience with on-demand radio stations; Apple News+, a subscription news and magazine service; Apple TV+, which offers exclusive original content; Apple Card, a co-branded credit card; and Apple Pay, a cashless payment service, as well as licenses its intellectual property. The company serves consumers, and small and mid-sized businesses; and the education, enterprise, and government markets. It distributes third-party applications for its products through the App Store. The company also sells its products through its retail and online stores, and direct sales force; and third-party cellular network carriers, wholesalers, retailers, and resellers. Apple Inc. was incorporated in 1977 and is headquartered in Cupertino, California."
   :ceo                 "Mr. Timothy D. Cook"
   :sector              "Technology"
   :country             "US"
   :fullTimeEmployees   164000
   :phone               "408 996 1010"
   :address             "One Apple Park Way"
   :city                "Cupertino"
   :state               "CA"
   :zip                 "95014"
   :dcfDiff             4.15176
   :dcf                 150.082
   :image               "https://financialmodelingprep.com/image-stock/AAPL.png"
   :ipoDate            "1980-12-12"
   :defaultImage       false
   :isEtf              false
   :isActivelyTrading  true
   :isAdr              false
   :isFund             false})

(def model-stock-informations
  #:stock{:symbol              "AAPL"
          :price               178.72
          :beta                1.286802
          :vol-avg             58405568
          :mkt-cap             2794144143933
          :last-div            0.96
          :range               "124.17-198.23"
          :changes             -0.13
          :company-name        "Apple Inc."
          :currency            "USD"
          :cik                 "0000320193"
          :isin                "US0378331005"
          :cusip               "037833100"
          :exchange            "NASDAQ Global Select"
          :exchange-short-name "NASDAQ"
          :industry            "Consumer Electronics"
          :website             "https://www.apple.com"
          :description         "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. It also sells various related services. In addition, the company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; AirPods Max, an over-ear wireless headphone; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, HomePod, and iPod touch. Further, it provides AppleCare support services; cloud services store services; and operates various platforms, including the App Store that allow customers to discover and download applications and digital content, such as books, music, video, games, and podcasts. Additionally, the company offers various services, such as Apple Arcade, a game subscription service; Apple Music, which offers users a curated listening experience with on-demand radio stations; Apple News+, a subscription news and magazine service; Apple TV+, which offers exclusive original content; Apple Card, a co-branded credit card; and Apple Pay, a cashless payment service, as well as licenses its intellectual property. The company serves consumers, and small and mid-sized businesses; and the education, enterprise, and government markets. It distributes third-party applications for its products through the App Store. The company also sells its products through its retail and online stores, and direct sales force; and third-party cellular network carriers, wholesalers, retailers, and resellers. Apple Inc. was incorporated in 1977 and is headquartered in Cupertino, California."
          :ceo                 "Mr. Timothy D. Cook"
          :sector              "Technology"
          :country             "US"
          :full-time-employees 164000
          :phone               "408 996 1010"
          :address             "One Apple Park Way"
          :city                "Cupertino"
          :state               "CA"
          :zip                 "95014"
          :dcf-diff            4.15176
          :dcf                 150.082
          :image               "https://financialmodelingprep.com/image-stock/AAPL.png"
          :ipo-date            "1980-12-12"
          :default-image       false
          :is-etf              false
          :is-actively-trading true
          :is-adr              false
          :is-fund             false})

(def wire-out-stock-informations
  {:symbol              "AAPL"
   :price               178.72
   :beta                1.286802
   :vol-avg             58405568
   :mkt-cap             2794144143933
   :last-div            0.96
   :range               "124.17-198.23"
   :changes             -0.13
   :company-name        "Apple Inc."
   :currency            "USD"
   :cik                 "0000320193"
   :isin                "US0378331005"
   :cusip               "037833100"
   :exchange            "NASDAQ Global Select"
   :exchange-short-name "NASDAQ"
   :industry            "Consumer Electronics"
   :website             "https://www.apple.com"
   :description         "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. It also sells various related services. In addition, the company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; AirPods Max, an over-ear wireless headphone; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, HomePod, and iPod touch. Further, it provides AppleCare support services; cloud services store services; and operates various platforms, including the App Store that allow customers to discover and download applications and digital content, such as books, music, video, games, and podcasts. Additionally, the company offers various services, such as Apple Arcade, a game subscription service; Apple Music, which offers users a curated listening experience with on-demand radio stations; Apple News+, a subscription news and magazine service; Apple TV+, which offers exclusive original content; Apple Card, a co-branded credit card; and Apple Pay, a cashless payment service, as well as licenses its intellectual property. The company serves consumers, and small and mid-sized businesses; and the education, enterprise, and government markets. It distributes third-party applications for its products through the App Store. The company also sells its products through its retail and online stores, and direct sales force; and third-party cellular network carriers, wholesalers, retailers, and resellers. Apple Inc. was incorporated in 1977 and is headquartered in Cupertino, California."
   :ceo                 "Mr. Timothy D. Cook"
   :sector              "Technology"
   :country             "US"
   :full-time-employees 164000
   :phone               "408 996 1010"
   :address             "One Apple Park Way"
   :city                "Cupertino"
   :state               "CA"
   :zip                 "95014"
   :dcf-diff            4.15176
   :dcf                 150.082
   :image               "https://financialmodelingprep.com/image-stock/AAPL.png"
   :ipo-date            "1980-12-12"
   :default-image       false
   :is-etf              false
   :is-actively-trading true
   :is-adr              false
   :is-fund             false})



(deftest wire->model-test
  (testing "Check the conversion of payload to the expected model"
    (is (= model
           (adapters.stock/wire->model wire-in)))))

(deftest model->wire-test
  (testing "Check the conversion of payload to the expected wire-out"
    (is (= wire-out
           (adapters.stock/model->wire model)))))

(deftest wire-stock-information->model-stock-information-test
  (testing "Check the conversion of payload to the expected model"
    (is (= model-stock-informations
           (adapters.stock/wire-stock-information->model-stock-information wire-in-stock-informations)))))

(deftest model-stock-information->wire-stock-information-test
  (testing "Check the conversion of payload to the expected wire-out"
    (is (= wire-out-stock-informations
           (adapters.stock/model-stock-information->wire-stock-information model-stock-informations)))))
