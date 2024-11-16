(ns financials.helpers)

(defn remove-vals
  [pred amap]
  (into {} (remove (comp pred val) amap)))