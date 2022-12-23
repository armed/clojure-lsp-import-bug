(ns lsp-repro.test
  (:require
   [malli.core :as m]
   [steffan-westcott.clj-otel.context :as clj-otel.context])
  (:import
   (io.opentelemetry.api.trace Span Tracer)))

(defn merge-context
  [context value-map]
  (reduce (fn [^Context ctx [k v]]
            (clj-otel.context/assoc-value ctx k v))
          context
          value-map))
