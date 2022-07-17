(defproject lipas "0.1.0-SNAPSHOT"
  :dependencies
  [[org.clojure/clojure "1.10.0"]     
   [org.clojure/clojurescript "1.10.520"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljc" "src/cljs"]

  :test-paths ["test/clj"]

  :profiles
  {:dev
   {:repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
    :dependencies
    [ [figwheel-sidecar "0.5.18"]
     [cider/piggieback "0.4.0"]]
    :plugins [[lein-figwheel "0.5.18"]]}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs" "src/cljc"]
     :figwheel     {:on-jsload "lipas.ui.core/mount-root"}
     :compiler
     {:main                 lipas.ui.core
      :npm-deps             false
      :infer-externs        true
      :output-to            "resources/public/js/compiled/app.js"
      :output-dir           "resources/public/js/compiled/out"
      :asset-path           "/js/compiled/out"
      :source-map-timestamp true}}]})
