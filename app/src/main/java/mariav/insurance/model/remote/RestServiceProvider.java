package mariav.insurance.model.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestServiceProvider {

    private static final RestServiceProvider INSTANCE = new RestServiceProvider();

    private RestService restService;


    public static RestServiceProvider getInstance() {
        return INSTANCE;
    }

    public synchronized final RestService getRestService() {
        if (restService == null) {
            restService = createRestService();
        }
        return restService;
    }

    private RestService createRestService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestService.BASE_URL)
                .client(provideClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(RestService.class);
    }

    private OkHttpClient provideClient() {
        HttpLoggingInterceptor logging = (new HttpLoggingInterceptor())
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }
}
