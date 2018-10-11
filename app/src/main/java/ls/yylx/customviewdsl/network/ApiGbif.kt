package ls.yylx.customviewdsl.network

import ls.yylx.customviewdsl.data.SpeciesBoxBack
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiGbif {



    @GET("species")
    fun getSpeciesBox(
            @Query("offset") offset: Int  = 0,
            @Query("limit") limit: Int = 1000,
            @QueryMap() map: Map<String, String> = emptyMap()
    ): Call<SpeciesBoxBack>

    //    uuid|shortname
    @GET("species/root/{search}")
    fun getSpeciesRoot(
            @Path("search") search: String

//            @Query("offset") offset: Int = 0,
//            @Query("limit") limit: Int = 1000,
    ): Call<String>



    @GET("species/{int}")
    fun getSingleSpecie(
            @Path("int") search: String


//            @Query("offset") offset: Int = 0,
//            @Query("limit") limit: Int = 1000,
    ): Call<String>





}