import com.example.maktabplus.data.response.ApiError

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Resource<out R>(
    val data: R? = null,
    val error: ApiError? = null
) {

    class Success<out T>(data: T) : Resource<T>(data)
    class Loading<out T>(data: T? = null) : Resource<T>(data)
    class Error(apiError: ApiError) : Resource<Nothing>(error = apiError)

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            is Loading -> "Loading"
            else -> "Not found type: ${this.javaClass.simpleName}"
        }
    }

    companion object {
        fun <T> success(data: T) = Success(data)
        fun <T> loading(data: T? = null) = Loading(data)
        fun error(apiError: ApiError) = Error(apiError)
    }

}

val <T> Resource<T>.isSuccess
    get() = this is Resource.Success && data != null