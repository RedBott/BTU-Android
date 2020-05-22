package com.example.examproject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


object DataLoader {
    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://sv443.net/jokeapi/v2/joke/")
        .build()

    private var service = retrofit.create(ApiRetrofit::class.java)

    fun getRequest(path:String,customCallback: CustomCallback){
        val call:Call<String> = service.getRequest(path)
        call.enqueue(callback(customCallback))
    }

    fun postRequest(path:String,parameters: MutableMap<String, String>,customCallback: CustomCallback){
        val call:Call<String> = service.postRequest(path,parameters)
        call.enqueue(callback(customCallback))


    }
    private fun callback(customCallback: CustomCallback) = object: Callback<String>{
        override fun onFailure(call: Call<String>, t: Throwable) {
            customCallback.onFailure(t.message.toString())
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            customCallback.onSuccess(response.body().toString())
        }
    }

}

interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") user: String?): Call<String>

    @FormUrlEncoded
    @POST("{path}")
    fun postRequest(@Path("path") user: String?,parameters:Map<String,String>): Call<String>
}