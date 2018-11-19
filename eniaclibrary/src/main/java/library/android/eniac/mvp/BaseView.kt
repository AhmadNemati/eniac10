package library.android.eniac.mvp

/**
 * Created by RezaNejati on 7/2/2018.
 */
interface BaseView<T> {
    //    void setPresenter(T presenter);
    fun showProgress()

    fun hideProgress()
    fun onError(message: String)

    fun onFinish(resultCode: Int)
}
