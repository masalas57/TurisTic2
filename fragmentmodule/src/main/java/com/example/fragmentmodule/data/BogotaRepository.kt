package com.example.fragmentmodule.data

class BogotaRepository {

    suspend fun getBogota() = ApiFactory.retrofit.getBogota()

}