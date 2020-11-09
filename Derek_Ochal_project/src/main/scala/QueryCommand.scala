// Encapsulated query or a query builder
class QueryCommand {
  val template = new Configs().template1;
  var var1 = ""

  def build(): QueryCommand = this
  def getString = template.replaceAll("##VAR1##", var1)
  def askFor(data: String): QueryCommand = {
    var1 += data + " "
    this
  }
}