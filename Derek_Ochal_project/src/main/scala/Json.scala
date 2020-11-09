import scala.collection.immutable.HashMap

// node containing a String if it's a leaf or a hash map if it's a branch
case class Json(contents:HashMap[String, Json] = null, content:String = null) {
  // returns multiline String with Json contents
  def getString(implicit tab: String = ""): String =
    contents match {
      case null => content + "\n"
      case _ => contents.foldLeft("{\n")((resultString, pair) => resultString + s"$tab     ${pair._1} : ${pair._2.getString(tab + "     ")}") + s"$tab}\n"
    }

  // no filter
  def filter(): Json = this
}