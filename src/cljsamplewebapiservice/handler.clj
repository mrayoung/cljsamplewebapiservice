(ns cljsamplewebapiservice.handler 
    (:require   [compojure.core :refer :all]
                [compojure.route :as route]
                [ring.middleware.json :as middleware]
                [ring.middleware.keyword-params :refer [wrap-keyword-params]]
                [ring.util.response :as response]))

(defn Access-Control-Allow-Headers
    "Access-Control-Allow-Headers"
    [handler]
    (fn [request]
        (let [response (handler request)]
            (assoc-in response [:headers "Access-Control-Allow-Headers"]"*"))))

(defn Access-Control-Allow-Methods
    "Access-Control-Allow-Headers"
    [handler]
    (fn [request]
        (let [response (handler request)]
         (assoc-in response [:headers "Access-Control-Allow-Methods"]"POST, GET, OPTIONS"))))

(defn allow-cross-origin  
    "middleware function to allow crosss origin"  
    [handler]
    (fn [request]  
     (let [response (handler request)]  
      (assoc-in response [:headers "Access-Control-Allow-Origin"]"*"))))

(defroutes app-routes
    (GET "/" [] (response/resource-response "apisrv.html" {:root "public"}))
    (GET "/status" [] 
        (try 
            {:status 400 :body {:message "Connection is Alive"}}
          (catch Exception e
                 {:status 400 :body {:message (.getMessage e)}}))))

(def app
    (-> app-routes
        allow-cross-origin
        Access-Control-Allow-Methods
        Access-Control-Allow-Headers
        wrap-keyword-params
        middleware/wrap-json-params
        middleware/wrap-json-response))
