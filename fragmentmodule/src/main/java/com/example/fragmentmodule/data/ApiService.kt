package com.example.fragmentmodule.data

import com.example.fragmentmodule.model.Cartagena
import retrofit2.http.GET

interface ApiService {

    @GET("MiguelVillada/Movil-Dev/bogota")
    suspend fun getBogota(): Cartagena

}