(defproject cljsamplewebapiservice "0.1.0-SNAPSHOT"
  :description "This is a sample Clojure web app for deployment testing."
  :url "https://github.com/mrayoung/cljsamplewebapiservice"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.2.1"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [compojure "1.1.6"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-ssl "0.3.0"]]
  
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-ring "0.8.11"]]

  :main ^:skip-aot cljsamplewebapiservice.core
  :ring {:handler cljsamplewebapiservice.handler/app}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
