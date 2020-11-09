import org.junit.Test
import org.junit.Assert._

class QueryCommandTest {

  @Test def test1()  {
    assertEquals(new QueryCommand().askFor("pass").build.getString, "{viewer {pass }}")
  }

  @Test def test2()  {
    assertEquals(new QueryCommand().askFor("").build.getString, "{viewer { }}")
  }

  @Test def test3()  {
    assertEquals(new QueryCommand().askFor(null).build.getString, "{viewer {null }}")
  }

  @Test def test4()  {
    assertEquals(new QueryCommand().askFor("1\n2").build.getString, "{viewer {1\n2 }}")
  }

  @Test def test5()  {
    assertEquals(new QueryCommand().askFor(":-) space").build.getString, "{viewer {:-) space }}")
  }
}
