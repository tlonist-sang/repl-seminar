(ns ReplDriven.simple
  (:require [ring.adapter.jetty :as j]
            [reitit.core :as r]
            [reitit.coercion.spec]
            [reitit.ring :as ring]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [reitit.ring.middleware.parameters :as parameters]
            [muuntaja.core :as m]))

(defn handler [_]
  (fn [{:keys [x y] :as request}]
    (prn "x->" x ", y->" y)
    {:status 200
     :body   (+ x y)}))

(def app
  (ring/ring-handler
    (ring/router
      ["/plus" {:post {:name       ::plus
                       :parameters {:query {:x int? :y int?}}
                       :responses  {200 {:body {:result int?}}}
                       :handler    (fn [{{:keys [x y] :as all} :body-params}]
                                     ;(prn "x->" x ", y->" y ", all->" all)
                                     (def *req all)
                                     {:status 200
                                      :body   {:result (+ x y)}})}}]
      {:data {:coercion reitit.coercion.spec/coercion
              :muuntaja m/instance
              :middleware [;; query-params & form-params
                           parameters/parameters-middleware
                           ;; content-negotiation
                           muuntaja/format-negotiate-middleware
                           ;; encoding response body
                           muuntaja/format-response-middleware
                           ;; decoding request body
                           muuntaja/format-request-middleware]}})))

;; var quote
;; 값 대신 var reference 자체를 넘길 때 사용한다.

(defn start []
  (j/run-jetty #'app {:port  3000
                      :join? false}))



(comment
  (start)
  (let [{:keys [x y]} *req]
    (prn x)
    (prn y))

  ,)

