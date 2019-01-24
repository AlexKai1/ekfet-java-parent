package com.ekfet.jsengine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JsEngine {

  public static void exec() throws Exception {

    ScriptEngineManager scriptEngine = new ScriptEngineManager();
    ScriptEngine jsEngine = scriptEngine.getEngineByName("JavaScript");
    Object script = jsEngine.eval(getScript());
    Invocable inv = (Invocable) jsEngine;
    System.out.println("script=" + script);
    Object result = inv.invokeFunction("getData");
    System.out.println("result" + result.toString());
  }

  public static String getScript() {
    String script =
        "function getData(){var data=[];var xValue=+new Date(2011,0,1);var minute=60*1000;var baseValue=Math.random()*12000;var boxVals=new Array(4);var dayRange=12;for(var i=0;i<100;i++){baseValue=baseValue+Math.random()*20-10;for(var j=0;j<4;j++){boxVals[j]=(Math.random()-0.5)*dayRange+baseValue}boxVals.sort();var idxRandom=Math.random();var openIdx=Math.round(Math.random()*3);var closeIdx=Math.round(Math.random()*2);if(closeIdx===openIdx){closeIdx++}var volumn=boxVals[3]*(1000+Math.random()*500);data[i]=[formatTime(xValue+=minute),+boxVals[openIdx].toFixed(2),+boxVals[3].toFixed(2),+boxVals[0].toFixed(2),+boxVals[closeIdx].toFixed(2),volumn.toFixed(0),]}return data}function formatTime(time){return new Date(time).Format(\"yyyy-MM-dd hh:mm:ss\")}Date.prototype.Format=function(fmt){var o={\"M+\":this.getMonth()+1,\"d+\":this.getDate(),\"h+\":this.getHours(),\"m+\":this.getMinutes(),\"s+\":this.getSeconds(),\"q+\":Math.floor((this.getMonth()+3)/3),\"S\":this.getMilliseconds()};if(/(y+)/.test(fmt)){fmt=fmt.replace(RegExp.$1,(this.getFullYear()+\"\").substr(4-RegExp.$1.length))}for(var k in o){if(new RegExp(\"(\"+k+\")\").test(fmt)){fmt=fmt.replace(RegExp.$1,(RegExp.$1.length==1)?(o[k]):((\"00\"+o[k]).substr((\"\"+o[k]).length)))}}return fmt};";
    return script;
  }

  public static void main(String[] args) throws Exception {
    exec();
  }
}
