(ns cljsamplewebapiservice.core
  (:require [cljsamplewebapiservice.handler  :as handler]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn -main []
  (jetty/run-jetty
        handler/app
        {:port 8080}))
