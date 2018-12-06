package com.ekfet.akka.scala

import akka.actor.{Actor, Status}

class ScalaPongActor extends  Actor{

  override def receive:Receive ={
    case "ping" =>sender()!"pong"
    case _ =>
      sender() !Status.Failure(new Exception("unkoown message"))
  }
}
