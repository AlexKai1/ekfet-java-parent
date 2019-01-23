package com.ekfet.grpc.server;

import com.ekfet.grpc.core.service.GreeterGrpc;
import com.ekfet.grpc.core.service.GreeterProto;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(GreeterProto.HelloRequest request, StreamObserver<GreeterProto.HelloReply> responseObserver) {

        GreeterProto.HelloReply reply = GreeterProto.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
//        super.sayHello(request, responseObserver);
    }
}
