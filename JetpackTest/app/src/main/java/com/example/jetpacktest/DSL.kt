package com.example.jetpacktest

import java.lang.StringBuilder

class TD {
    var content = ""
    fun html() = "\n\t\t<td>$content<td>"
}
class TR {
    val children = ArrayList<TD>()
    fun t(block : TD.() -> String) {
        val d = TD()
        d.content = d.block()
        children.add(d)
    }
    fun h() : String {
        val b = StringBuilder()
        b.append("\n\t</tr>")
        return b.toString()
    }
}