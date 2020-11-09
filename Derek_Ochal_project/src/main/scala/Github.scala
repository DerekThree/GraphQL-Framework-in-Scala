import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.json4s.DefaultFormats
import scala.collection.immutable.HashMap
import scala.io.Source

// Github object. Once built, it will have an endpoint to the developer account specified in the token
// It can be queried with a QueryCommand, returning an instance of Json class
case class Github() {
  val BASE_GHQL_URL = "https://api.github.com/graphql"
  implicit val formats = DefaultFormats
  val client = HttpClientBuilder.create.build
  val httpUriRequest = new HttpPost(BASE_GHQL_URL)

  // Returns a result of QueryCommand as a Json
  def query(queryCommand: QueryCommand): Json = {
    httpUriRequest.setEntity(new StringEntity("{\"query\":\"" + queryCommand.getString + "\"}" ))
    val response = client.execute(httpUriRequest)

    response.getEntity match {
      case null => Json()
      case x => {
        val respJson = Source.fromInputStream(x.getContent).getLines.mkString
        jsonFromString(respJson)
      }
    }
  }

  // TODO: implement
  // takes a string representing a json and returns an instance of Json class
  def jsonFromString(string: String): Json = {

//    return string.toList match {
//      case '"' :: name :: '"' :: _ => Json(content = string.split('"').head)
//      case '{' :: name :: ':' :: _ => Json(HashMap(("name", jsonFromString(_))))
//    }

    new Configs().logger.error("Unimplemented function jsonFromString\nPretending to get json from: " + string)
    // Json from constructors for now
    val viewerJson = Json(HashMap(
      "name" -> Json(content = "Dariusz Ochal"),
      "login" -> Json(content = "DerekTwo"),
      "url" -> Json(content = "https://github.com/DerekTwo")))
    val dataJson = Json(HashMap("viewer" -> viewerJson))
    Json(HashMap("data" -> dataJson))
  }

  // Sets the value of an authorization token
  def setAuthorization(value: String): Github = {
    httpUriRequest.addHeader("Authorization", value)
    this
  }

  // Adds a header
  def setHeader(name: String, value: String): Github = {
    httpUriRequest.addHeader(name, value)
    this
  }

  // Builder pattern
  def build() = this // it's ready
}
