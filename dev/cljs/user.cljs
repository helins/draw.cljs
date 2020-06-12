(ns cljs.user

  "For daydreaming in the repl."

  (:require [dvlopt.draw :as draw]))



;;;;;;;;;;
  

(defn draw-frame

  [ctx]

  (-> ctx
      (draw/color-fill (draw/grad-linear ctx 0 0 1000 400 [[0   "black"]
                                                           [0.5 "blue"]
                                                           [1   "black"]]))
      (draw/rect-fill 0 0 1000 400)
      (draw/color-fill "white")
      (draw/color-stroke "grey")
      (draw/line-width 2)
      (draw/font "bold 200px serif")
      (draw/text-fill 50 100 "Hello")
      (draw/shadow 10 10 10 "green")
      (draw/text-stroke 100 200 "Hello")
      ))



(comment


  (def c
       (goog.dom.createElement "canvas"))

  (goog.dom.setProperties c
                          #js {"style" "height:400px; width:1000px;"})

  (goog.dom.appendChild js/document.body
                        c)


  (def ctx
       (draw/high-dpi (.getContext c
                                   "2d"
                                   #js {"alpha" false})))


  (do
    (frame)
    (def frame
      (draw/on-frame (fn draw [_timestamp]
                       (try
                         (draw-frame ctx)
                         true
                         (catch :default e
                           (js/console.log "err" e)
                           false))))))


  )
