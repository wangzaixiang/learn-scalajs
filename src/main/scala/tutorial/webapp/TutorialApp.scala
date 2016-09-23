package tutorial.webapp

import java.util.Date

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.{document, window}
import org.scalajs.jquery.jQuery

import scala.concurrent.{ExecutionContext, Future, Promise}
import ExecutionContext.Implicits.global
import scala.async.Async.{async, await}

object TutorialApp extends JSApp {
  def main(): Unit = {
    println("Hello world!")
    queryUsers.onSuccess({ case res => println(s"${new Date} result is $res")})
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def queryA: Future[String] = {
    val promise: Promise[String] = Promise()
    window.setTimeout({ () => println(new Date + " success A"); promise.success("Hello") }, 2000)
    promise.future
  }

  def queryB: Future[String] = {
    val promise = Promise[String]()
    window.setTimeout({ () => println(new Date + " success B"); promise.success("world") }, 5000)
    promise.future
  }

  def queryUsers: Future[String] = async {
    val a = await(queryA)
    val b = await(queryB)
    a + " " + b
  }

}
