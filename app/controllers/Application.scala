package controllers

import java.util.concurrent.atomic.AtomicLong
import play.api._
import play.api.mvc._
import actors.MyWebSocketActor
import play.api.Play.current

object Application extends Controller {


  private final val conns: AtomicLong = new AtomicLong

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def ws = WebSocket.acceptWithActor[String, String] { request => out => {
    val id = conns.incrementAndGet()
    Logger.debug("New connection: " + id)
    MyWebSocketActor.props(out, id)
  }

  }

}
