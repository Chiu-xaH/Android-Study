package com.example.networktest

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler
import kotlin.text.StringBuilder

class MyHandler : DefaultHandler() {

    var nodename = ""
    lateinit var id: StringBuilder
    lateinit var  name : StringBuilder
    lateinit var version : StringBuilder

    //开始解析XML
    override fun startDocument() {
        super.startDocument()
        id = StringBuilder()
        name = StringBuilder()
        version = StringBuilder()
    }
    //开始解析节点
    override fun startElement(uri: String?, localName: String?, qName: String?, attributes: Attributes?) {
        super.startElement(uri, localName, qName, attributes)
        if (localName != null) { nodename = localName }
        Log.d("A测试1","uri是 $uri")
        Log.d("A测试2","localName是 $localName")
        Log.d("A测试3","qName是 $qName")
        Log.d("A测试4","attributes是 $attributes")
    }
    //获取节点内容
    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
        when (nodename) {
            "id" -> id.append(ch,start,length)
            "name" -> name.append(ch,start,length)
            "version" -> version.append(ch,start,length)
        }
    }
    //结束解析节点
    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        if ("app" == localName) {
            Log.d("B测试1","id是 ${id.toString().trim()}")
            Log.d("B测试2","name是 ${name.toString().trim()}")
            Log.d("B测试3","version是 ${version.toString().trim()}")
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }
    //结束解析XML
    override fun endDocument() {
        super.endDocument()
    }

}