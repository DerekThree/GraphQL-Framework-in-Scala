// Example program demonstrating how to use our framework
object Example {
  def main(args: Array[String]): Unit = {

    // -- general outline for the code that a programmer will write to execute external commands using your framework --
    val gitHubObject = (new Github).setAuthorization("Bearer be4f6e8915f58ad90cc4f64d3bd7839614381d73").setHeader("Accept", "application/json").build()
    val result = gitHubObject.query((new QueryCommand()).askFor("name").askFor("login").askFor("url").build()).filter()
    // -----------------------------------------------------------------------------------------------------------------

    print(result.getString)
  }
}
