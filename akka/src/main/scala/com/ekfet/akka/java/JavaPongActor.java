package com.ekfet.akka.java;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class JavaPongActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().matchEquals("ping", s ->
                sender().tell("pong", ActorRef.noSender()))
                .matchAny(x -> sender().tell(new Status.Failure(new Exception("")), self()))
                .build();
    }
}
