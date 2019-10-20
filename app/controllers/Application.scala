package controllers
import javax.inject.{Inject, Singleton}
import play.api.mvc._
@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok("It done!")
  }

  // result的content type是从你指定的响应体的Scala值中自动推断的。
  // Content-Type: application/xml;
  def text = Action{
    Ok(<message>Hello World!</message>)
  }

  def html = Action {
    Ok(<h1>Hello World!</h1>).as(HTML)
  }

  def withHeaders = Action{
    Ok("Hello World").withHeaders(
      CACHE_CONTROL -> "max-age=3600",
      ETAG -> "xx"
    )
  }

  def cookie = Action {
    val result = Ok("Hello World").withCookies(
      Cookie("theme","blue")
    )
    val result1 = result.discardingCookies(DiscardingCookie("theme"))
    result1
  }


}