package actors

import akka.actor.{Props, ActorRef, ActorLogging, Actor}

/**
 * Created by arefaey on 8/7/14.
 */

object MyWebSocketActor {
  def props(out: ActorRef, id: Long) = Props(classOf[MyWebSocketActor], out, id)
}

class MyWebSocketActor(out: ActorRef, id: Long) extends Actor with ActorLogging {
  /*
  Send an identifier back to the client
   */

  override def preStart() = {
    val msg = "Connection ID: " + id.toString
    log.info(msg)
    out ! msg
  }

  def receive = {
    case msg: String =>
      out ! msg
  }

}
