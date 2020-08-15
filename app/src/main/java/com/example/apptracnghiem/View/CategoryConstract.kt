package com.example.apptracnghiem.View

import org.json.JSONArray


interface CategoryConstract {

    interface View: BaseView<Presenter> {
        fun showError(error:String)
        fun addArraylist(data:JSONArray)
    }
    interface Presenter {
        fun dataCate()
    }
}