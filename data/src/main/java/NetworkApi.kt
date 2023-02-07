import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object NetworkApi {

    fun getClient(okHttpClient: OkHttpClient, converterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    fun provideOkkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun provideConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

}
