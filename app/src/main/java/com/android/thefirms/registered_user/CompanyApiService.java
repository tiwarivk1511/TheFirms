package com.android.thefirms.registered_user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface CompanyApiService {

    @GET("companies")
    Call<List<Company>> getCompanies(@Query("query") String query);

    // Other API methods if needed...
}