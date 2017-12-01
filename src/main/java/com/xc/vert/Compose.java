package com.xc.vert;

import com.sun.nio.sctp.ShutdownNotification;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import io.vertx.core.json.JsonObject;

/**
 * TODO:TODO
 * Auther:徐成
 * Date:2017/11/30
 * Email:old_camel@126.com
 */
public class Compose
{
    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();
        //FileSystem fileSystem = vertx.fileSystem();
        //System.out.println("cdijaids a" );
        //shunxuhebking();
        JsonObject config = new JsonObject().put("name", "xucheng");
                vertx.deployVerticle("com.xc.vert.MyFirstVerticle",new DeploymentOptions().setConfig(config));

//并发合并
    }
    public static void shunxuhebking(){
        Vertx vertx = Vertx.vertx();
FileSystem fs = vertx.fileSystem();
Future<Void> startFuture = Future.future();

Future<Void> fut1 = Future.future();
fs.createFile("E:/foo/1", fut1.completer());

fut1.compose(v->{
    //dosomething
    //Future<Void> future = Future.future();
    //return future;
},startFuture).compose(r->{
    //dosomething
},startFuture).compose(r->{},startFuture);


fut1.compose(v -> {
  // fut1中文件创建完成后执行
  Future<Void> fut2 = Future.future();

  fs.writeFile("E:/foo/1", Buffer.buffer(), fut2.completer());
  return fut2;
}).compose(v -> {
  // fut2文件写入完成后执行
  fs.move("E:/foo/1", "E:/bar/1", startFuture.completer());
},
  // 如果任何一步失败，将startFuture标记成failed
  startFuture);
    }
}




