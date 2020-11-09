import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory

// Class with all the configs
class Configs {
  val config = ConfigFactory.load()
  val logger = LoggerFactory.getLogger("Configs")

  val template1 = config.getString("template1")
}
